package com.Vehicle_Repair_System_BackEnd.utils;

import org.springframework.data.util.Pair;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

public class PasswordUtils {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String REGEX = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^\\s]).{8,}$";
    private static final String HASH_ALGORITHM = "SHA1PRNG";
    private final static int ITERATION_NUMBER = 842;

    public static boolean isSaltAndPasswordEquals(String inputPassword, String storedPassword, String salt) {
        try {
            byte[] bDigest = base64ToByte(storedPassword);
            byte[] bSalt = base64ToByte(salt);
            byte[] proposedDigest = getHash(ITERATION_NUMBER, inputPassword, bSalt);
            return Arrays.equals(proposedDigest, bDigest);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static Pair<String, String> createCredentials(String password) {
        try {
            final SecureRandom random = SecureRandom.getInstance(HASH_ALGORITHM);
            var bSalt = new byte[8];
            random.nextBytes(bSalt);
            return Pair.of(
                    byteToBase64(getHash(ITERATION_NUMBER, password, bSalt)),
                    byteToBase64(bSalt)
            );
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException("Something went wrong with createCredentials");
        }
    }

    private static byte[] getHash(int iterationNb, String password, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.reset();
        digest.update(salt);
        byte[] input = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        for (int i = 0; i < iterationNb; i++) {
            digest.reset();
            input = digest.digest(input);
        }
        return input;
    }

    private static byte[] base64ToByte(String data) {
        return Base64.getDecoder().decode(data);
    }

    /**
     * From a byte[] returns a base 64 representation
     *
     * @param data byte[]
     * @return String
     */
    private static String byteToBase64(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    public static String generateRandomPassword() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }
}
