package com.robosh.ejournal.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.robosh.ejournal.constant.Constants.PASSWORD_LENGTH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordGeneratorTest {

    private PasswordGenerator passwordGenerator;
    private static final String LOWER_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_LETTERS = LOWER_LETTERS.toUpperCase();
    private static final String NUMBERS = "0123456789";
    private static final String CHARS = "!@#$%&*()_+-=[]?";
    public static final int DEFAULT_PASSWORD_LENGTH = PasswordGenerator.DEFAULT_PASSWORD_LENGTH;

    @Test
    public void should_generatePasswordWithDefaultLength_When_lengthNotReceived() {
        passwordGenerator = getStrongPasswordGenerator();
        String result = passwordGenerator.generateRandomPassword();
        assertEquals(DEFAULT_PASSWORD_LENGTH, result.length());
    }

    @Test
    public void should_generatePasswordWithWithReceivedLength_When_lengthIsReceived() {
        final int passwordLength = 10;
        passwordGenerator = getStrongPasswordGenerator();
        String result = passwordGenerator.generateRandomPassword(passwordLength);
        assertEquals(passwordLength, result.length());
    }

    @Test
    public void should_generatePasswordWithLowerLettersOnly_When_True() {
        passwordGenerator = PasswordGenerator.builder()
                .isAllowLowerLetters(true)
                .build();
        String result = passwordGenerator.generateRandomPassword();

        assertTrue(stringContainsItemFromList(result, LOWER_LETTERS));

        assertFalse(stringContainsItemFromList(result, UPPER_LETTERS));
        assertFalse(stringContainsItemFromList(result, CHARS));
        assertFalse(stringContainsItemFromList(result, NUMBERS));
    }

    @Test
    public void should_generatePasswordWithUpperLettersOnly_When_True() {
        passwordGenerator = PasswordGenerator.builder()
                .isAllowUpperLetters(true)
                .build();
        String result = passwordGenerator.generateRandomPassword();

        assertTrue(stringContainsItemFromList(result, UPPER_LETTERS));

        assertFalse(stringContainsItemFromList(result, LOWER_LETTERS));
        assertFalse(stringContainsItemFromList(result, CHARS));
        assertFalse(stringContainsItemFromList(result, NUMBERS));
    }

    @Test
    public void should_generatePasswordWithCharsOnly_When_True() {
        passwordGenerator = PasswordGenerator.builder()
                .isAllowChars(true)
                .build();
        String result = passwordGenerator.generateRandomPassword();

        assertTrue(stringContainsItemFromList(result, CHARS));

        assertFalse(stringContainsItemFromList(result, LOWER_LETTERS));
        assertFalse(stringContainsItemFromList(result, UPPER_LETTERS));
        assertFalse(stringContainsItemFromList(result, NUMBERS));
    }

    @Test
    public void should_generatePasswordWithNumbersOnly_When_True() {
        passwordGenerator = PasswordGenerator.builder()
                .isAllowNumber(true)
                .build();
        String result = passwordGenerator.generateRandomPassword();

        assertTrue(stringContainsItemFromList(result, NUMBERS));

        assertFalse(stringContainsItemFromList(result, LOWER_LETTERS));
        assertFalse(stringContainsItemFromList(result, UPPER_LETTERS));
        assertFalse(stringContainsItemFromList(result, CHARS));
    }

    private PasswordGenerator getStrongPasswordGenerator() {
        return PasswordGenerator.builder()
                .isAllowChars(true)
                .isAllowNumber(true)
                .isAllowUpperLetters(true)
                .isAllowLowerLetters(true)
                .passwordLength(PASSWORD_LENGTH)
                .build();
    }

    private boolean stringContainsItemFromList(String inputStr, String items) {
        String[] arrayOfItems = items.split("");
        return Arrays.stream(arrayOfItems).parallel().anyMatch(inputStr::contains);
    }
}