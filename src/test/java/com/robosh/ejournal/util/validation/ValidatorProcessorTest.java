package com.robosh.ejournal.util.validation;

import com.robosh.ejournal.config.BeanConfig;
import com.robosh.ejournal.data.entity.admin.Admin;
import com.robosh.ejournal.data.entity.admin.AdminRole;
import com.robosh.ejournal.data.repository.ValidationRepository;
import com.robosh.ejournal.exception.ValidationException;
import com.robosh.ejournal.service.ValidationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.robosh.ejournal.data.DummyData.EMPTY_STRING;
import static com.robosh.ejournal.data.DummyData.INCORRECT_EMAIL;
import static com.robosh.ejournal.data.DummyData.PASSWORD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {
        BeanConfig.class,
        ValidationService.class
})
class ValidatorProcessorTest {

    @MockBean
    private ValidationRepository mockedValidationRepository;

    @Test
    void Should_ThrowException_WhenDataIncorrect() {
        when(mockedValidationRepository.isUnique(any(), any(), any())).thenReturn(false);

        Admin invalidAdmin = getNotValidAdmin();
        ValidationException validationException = assertThrows(ValidationException.class,
                () -> ValidatorProcessor.validate(invalidAdmin));
        assertEquals(4, validationException.getViolations().size());
    }

    private Admin getNotValidAdmin() {
        return Admin.builder()
                .firstName(EMPTY_STRING)
                .lastName(EMPTY_STRING)
                .adminRole(AdminRole.ADMIN)
                .email(INCORRECT_EMAIL)
                .password(PASSWORD)
                .build();
    }
}
