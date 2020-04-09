package com.robosh.ejournal.util.validation;

import com.robosh.ejournal.constant.Regex;
import com.robosh.ejournal.util.validation.annotation.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<Phone, String> {

    @Override
    public void initialize(Phone constraintAnnotation) {

    }

    @Override
    public boolean isValid(String phoneField, ConstraintValidatorContext context) {
        return phoneField != null && phoneField.matches(Regex.PHONE_NUMBER.getRegex());
    }
}
