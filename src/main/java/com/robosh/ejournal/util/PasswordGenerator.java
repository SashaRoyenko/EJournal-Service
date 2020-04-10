package com.robosh.ejournal.util;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Setter
@Getter
@Builder
public class PasswordGenerator {

    private static final String LOWER_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_LETTERS = LOWER_LETTERS.toUpperCase();
    private static final String NUMBERS = "0123456789";
    private static final String CHARS = "!@#$%&*()_+-=[]?";

    private static final SecureRandom random = new SecureRandom();
    public static final int DEFAULT_PASSWORD_LENGTH = 8;

    private final boolean isAllowUpperLetters;
    private final boolean isAllowLowerLetters;
    private final boolean isAllowNumber;
    private final boolean isAllowChars;
    private final int passwordLength;

    public String generateRandomPassword(int passwordLength) {

        StringBuilder passwordBuilder = new StringBuilder(passwordLength);
        String passwordElements = getPasswordElements();

        for (int i = 0; i < passwordLength; i++) {

            int rndCharAt = random.nextInt(passwordElements.length());
            char rndChar = passwordElements.charAt(rndCharAt);

            passwordBuilder.append(rndChar);
        }

        return passwordBuilder.toString();
    }

    public String generateRandomPassword() {
        return generateRandomPassword(passwordLength == 0 ? DEFAULT_PASSWORD_LENGTH : passwordLength);
    }

    private String shuffleString(String string) {
        List<String> letters = Arrays.asList(string.split(""));
        Collections.shuffle(letters);
        return String.join("", letters);
    }

    private String getPasswordElements() {
        StringBuilder passwordElementsBuilder = new StringBuilder();

        if (isAllowUpperLetters) {
            passwordElementsBuilder.append(UPPER_LETTERS);
        }
        if (isAllowLowerLetters) {
            passwordElementsBuilder.append(LOWER_LETTERS);
        }
        if (isAllowChars) {
            passwordElementsBuilder.append(CHARS);
        }
        if (isAllowNumber) {
            passwordElementsBuilder.append(NUMBERS);
        }

        return shuffleString(passwordElementsBuilder.toString());
    }
}
