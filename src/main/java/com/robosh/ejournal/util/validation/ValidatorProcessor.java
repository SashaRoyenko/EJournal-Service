package com.robosh.ejournal.util.validation;

import com.robosh.ejournal.exception.ValidationException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class ValidatorProcessor {

    private static Validator validator;

    static {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }

    private ValidatorProcessor() {
    }

    @SneakyThrows
    public static void validate(Object object) {
        log.info("Start validation {}", object.getClass().getSimpleName());
        Set<ConstraintViolation<Object>> validates = validator.validate(object);

        List<Map<String, String>> violations = new ArrayList<>();
        for (ConstraintViolation<Object> validate : validates) {
            Map<String, String> violation = new HashMap<>();
            violation.put("Field", validate.getPropertyPath().toString());
            violation.put("ValidationErrorMessage", validate.getMessage());
            violations.add(violation);
        }

        if (!violations.isEmpty()) {
            log.info("ViolationsError: {}", violations);
            throw new ValidationException(violations);
        }
    }
}
