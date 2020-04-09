package com.robosh.ejournal.util.validation;

import com.robosh.ejournal.factory.BeansFactory;
import com.robosh.ejournal.service.ValidationService;
import com.robosh.ejournal.util.validation.annotation.Unique;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueFieldValidator implements ConstraintValidator<Unique, String> {

    private ValidationService validationService;

    private String table;
    private String column;

    @Override
    public void initialize(Unique constraintAnnotation) {
        this.table = constraintAnnotation.table();
        this.column = constraintAnnotation.column();
        this.validationService = BeansFactory.getInstance().getValidationService();
    }

    @Override
    public boolean isValid(String field, ConstraintValidatorContext constraintValidatorContext) {
        return validationService.isUnique(table, column, field);
    }

}
