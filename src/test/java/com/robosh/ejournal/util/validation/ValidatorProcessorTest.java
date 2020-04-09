package com.robosh.ejournal.util.validation;

import com.robosh.ejournal.data.entity.admin.Admin;
import com.robosh.ejournal.data.entity.admin.AdminRole;
import com.robosh.ejournal.exception.ValidationException;
import org.junit.jupiter.api.Test;

import static com.robosh.ejournal.data.DummyData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorProcessorTest {

    @Test
    void Should_ThrowException_WhenDataIncorrect() {
        Admin invalidAdmin = getNotValidAdmin();
        ValidationException validationException = assertThrows(ValidationException.class,
                () -> ValidatorProcessor.validate(invalidAdmin));
        assertEquals(2, validationException.getViolations().size());
    }

    private Admin getNotValidAdmin() {
        return Admin.builder()
                .firstName(EMPTY_STRING)
                .lastName(EMPTY_STRING)
                .adminRole(AdminRole.ADMIN)
                .email(EMAIL)
                .password(PASSWORD)
                .build();
    }
}
