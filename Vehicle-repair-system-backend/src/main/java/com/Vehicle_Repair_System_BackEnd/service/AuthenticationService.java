package com.Vehicle_Repair_System_BackEnd.service;

import com.Vehicle_Repair_System_BackEnd.controller.model.LoginRequest;
import com.Vehicle_Repair_System_BackEnd.model.User;
import com.Vehicle_Repair_System_BackEnd.repository.UserRepository;
import com.Vehicle_Repair_System_BackEnd.utils.JwtUtils;
import com.Vehicle_Repair_System_BackEnd.utils.PasswordUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.function.Function;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    final Function<HttpStatus, ResponseStatusException> responseStatusEx = status ->
            new ResponseStatusException(HttpStatusCode.valueOf(status.value()));
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;


    public String login(@Valid LoginRequest loginRequest) {
        final User user = userRepository.findByUsername(loginRequest.username())
                .orElseThrow(() -> responseStatusEx.apply(HttpStatus.FORBIDDEN));

        boolean saltAndPasswordEquals = PasswordUtils.isSaltAndPasswordEquals(loginRequest.password(), user.getHashedPassword(), user.getSalt());
        if (!saltAndPasswordEquals) {
            throw responseStatusEx.apply(HttpStatus.BAD_REQUEST);
        }

        return jwtUtils.generateToken(loginRequest.username());

    }
}
