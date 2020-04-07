package com.robosh.ejournal.util.validation;

import com.robosh.ejournal.util.validation.annotation.PhoneNumberConstraint;
import com.robosh.ejournal.util.validation.regex.Regex;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberConstraint, String> {

    @Override
    public void initialize(PhoneNumberConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String phoneField, ConstraintValidatorContext context) {
        return phoneField != null && phoneField.matches(Regex.PHONE_NUMBER.getRegex());
    }
}
