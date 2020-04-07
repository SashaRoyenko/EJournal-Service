package com.robosh.ejournal.exception;

import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class ValidationException extends RuntimeException {

    private List<Map<String, String>> violations;

    public ValidationException() {
        super();
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, List<Map<String, String>> violations) {
        super(message);
        this.violations = violations;
    }

    public ValidationException(List<Map<String, String>> violations) {
        this.violations = violations;
    }
}
