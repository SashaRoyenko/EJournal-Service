package com.robosh.ejournal.util.validation;

import com.robosh.ejournal.factory.BeansFactory;
import com.robosh.ejournal.service.AdminService;
import com.robosh.ejournal.util.validation.annotation.Unique;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Service
public class UniqueFieldValidator implements ConstraintValidator<Unique, String> {

    private AdminService adminService = new BeansFactory().getAdminService();

    private String table;
    private String column;

    @Override
    public void initialize(Unique constraintAnnotation) {
        this.table = constraintAnnotation.table();
        this.column = constraintAnnotation.column();
    }

    @Override
    public boolean isValid(String field, ConstraintValidatorContext constraintValidatorContext) {
        return adminService.findAll().isEmpty();
    }

}
