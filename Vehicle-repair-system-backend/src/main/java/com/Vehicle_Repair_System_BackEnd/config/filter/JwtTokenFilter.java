package com.Vehicle_Repair_System_BackEnd.config.filter;

import com.Vehicle_Repair_System_BackEnd.model.User;
import com.Vehicle_Repair_System_BackEnd.repository.UserRepository;
import com.Vehicle_Repair_System_BackEnd.utils.JwtUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.server.resource.BearerTokenError;
import org.springframework.security.oauth2.server.resource.BearerTokenErrors;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Objects.isNull;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    public static final String TOKEN_PREFIX_BEARER = "Bearer";
    private static final Pattern authorizationPattern = Pattern.compile(
            "^Bearer (?<token>[a-zA-Z0-9-._~+/]+=*)$", Pattern.CASE_INSENSITIVE
    );
    private final JwtUtils jwtUtil;
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    public final BiFunction<String, HttpStatus, String> error = (message, status) -> {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("statusName", status);
        errorResponse.put("statusCode", status.value());
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("message", message);

        return this.toJson(errorResponse);
    };

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws IOException, ServletException {
        final String authorizationHeaderToken = this.resolveFromAuthorizationHeader(request);
        if (authorizationHeaderToken == null) {
            this.logger.trace("Did not process request since did not find bearer token");
            filterChain.doFilter(request, response);
            return;
        }
        String username;
        try {
            username = jwtUtil.extractUsername(authorizationHeaderToken);
        } catch (Exception ex) {
            setErrorResponse(response, ex.getMessage());
            return;
        }

        final Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            setErrorResponse(response, "User not found");
            return;
        }

        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (isNull(auth)) {
            var authentication = new UsernamePasswordAuthenticationToken(
                    userOptional.get().getUsername(),
                    null,
                    List.of(
                            new SimpleGrantedAuthority("ROLE_" + userOptional.get().getUserType().getName().name())
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        log.debug("authenticated user {} setting security context", username);
        filterChain.doFilter(request, response);
    }

    private String resolveFromAuthorizationHeader(HttpServletRequest request) {
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (!StringUtils.startsWithIgnoreCase(authorization, TOKEN_PREFIX_BEARER)) {
            return null;
        }
        Matcher matcher = authorizationPattern.matcher(authorization);
        if (!matcher.matches()) {
            BearerTokenError error = BearerTokenErrors.invalidToken("Bearer token is malformed");
            throw new OAuth2AuthenticationException(error);
        }
        return matcher.group("token");
    }

    private void setErrorResponse(@NonNull HttpServletResponse response,
                                  final String message) throws IOException {
        response.setStatus(HttpStatus.FORBIDDEN.value());

        response.setContentType(APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.getWriter().write(this.error.apply(message, HttpStatus.FORBIDDEN));
        response.getWriter().flush();
        response.getWriter().close();
    }

    private String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            log.error("Error in JSON parsing", ex);
        }
        return null;
    }
}
