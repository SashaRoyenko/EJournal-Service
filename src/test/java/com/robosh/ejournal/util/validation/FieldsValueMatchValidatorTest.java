package com.robosh.ejournal.util.validation;

import com.robosh.ejournal.data.dto.admin.SaveAdminDto;
import com.robosh.ejournal.data.entity.admin.AdminRole;
import com.robosh.ejournal.util.validation.annotation.FieldsValueMatch;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static com.robosh.ejournal.data.DummyData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FieldsValueMatchValidatorTest {

    private static Validator validator;

    static {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }

    @Test
    void Should_ProduceConstraintViolation_When_PasswordsNotEqual() {
        SaveAdminDto adminWithNotEqualPassword = getSaveAdminDtoWithNotEqualPassword();
        Set<ConstraintViolation<Object>> validates = validator.validate(adminWithNotEqualPassword);

        String resultAnnotation = getAnnotationName(validates.iterator().next());
        String expectedAnnotation = FieldsValueMatch.class.getName();

        assertEquals(1, validates.size());
        assertEquals(expectedAnnotation, resultAnnotation);
    }

    private SaveAdminDto getSaveAdminDtoWithNotEqualPassword() {
        return SaveAdminDto.builder()
                .firstName(NAME)
                .lastName(NAME)
                .adminRole(AdminRole.ADMIN)
                .email(EMAIL)
                .password(PASSWORD)
                .confirmedPassword(EMPTY_STRING)
                .schoolId(ANY_LONG)
                .build();
    }

    private String getAnnotationName(ConstraintViolation<Object> constraintViolation) {
        return constraintViolation.getConstraintDescriptor().getAnnotation().annotationType().getName();
    }
}
