package com.robosh.ejournal.service;

import com.robosh.ejournal.config.BeanConfig;
import com.robosh.ejournal.data.dto.parent.ParentDto;
import com.robosh.ejournal.data.dto.parent.SaveParentDto;
import com.robosh.ejournal.data.dto.parent.UpdateParentDto;
import com.robosh.ejournal.data.entity.Parent;
import com.robosh.ejournal.data.entity.School;
import com.robosh.ejournal.data.entity.Student;
import com.robosh.ejournal.data.repository.ParentRepository;
import com.robosh.ejournal.data.repository.ValidationRepository;
import com.robosh.ejournal.exception.ResourceNotFoundException;
import com.robosh.ejournal.exception.ValidationException;
import config.MapperConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static com.robosh.ejournal.data.DummyData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {
        ParentService.class,
        MapperConfiguration.class,
        BeanConfig.class,
        ValidationService.class
})
class ParentServiceTest {

    @Autowired
    private ParentService parentService;

    @MockBean
    private ParentRepository mockedParentRepository;

    @MockBean
    private ValidationRepository validationRepository;

    @Test
    void should_ReturnParentDto_When_GivenValidData() {
        when(mockedParentRepository.save(any())).thenReturn(getParent());

        assertEquals(getParentDto(), parentService.save(getSaveParentDto()));
    }

    @Test
    void should_ThrowValidationException_When_GivenInvalidSaveParentDto() {
        SaveParentDto invalidDto = getSaveParentDto();
        invalidDto.setEmail(INCORRECT_EMAIL);

        assertThrows(ValidationException.class, () -> parentService.save(invalidDto));
    }

    @Test
    void should_ReturnUpdatedParent_When_GivenValidData() {
        Parent updatedParent = getParent();
        updatedParent.setFirstName(getUpdateParentDto().getFirstName());
        ParentDto updatedParentDto = getParentDto();
        updatedParent.setFirstName(getUpdateParentDto().getFirstName());

        when(mockedParentRepository.findById(ANY_LONG)).thenReturn(Optional.of(getParent()));
        when(mockedParentRepository.save(updatedParent)).thenReturn(updatedParent);

        assertEquals(updatedParentDto, parentService.update(getUpdateParentDto()));
    }

    @Test
    void should_ThrowResourceNotFoundException_When_FindByIdReturnNull() {
        when(mockedParentRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> parentService.update(getUpdateParentDto()));
    }

    @Test
    void should_ThrowValidationException_When_GivenInvalidUpdateDto() {
        UpdateParentDto invalidUpdateDto = getUpdateParentDto();
        invalidUpdateDto.setFirstName(EMPTY_STRING);

        when(mockedParentRepository.findById(ANY_LONG)).thenReturn(Optional.of(getParent()));

        assertThrows(ValidationException.class, () -> parentService.update(invalidUpdateDto));
    }

    @Test
    void should_ReturnEntityWithSameId_When_RepositoryReturnEntity() {
        when(mockedParentRepository.findById(ANY_LONG)).thenReturn(Optional.of(getParent()));

        assertEquals(ANY_LONG, parentService.findById(ANY_LONG).getId());
    }

    @Test
    void should_ThrowResourceNotFoundException_When_RepositoryReturnNull(){
        when(mockedParentRepository.findById(ANY_LONG)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> parentService.findById(ANY_LONG));
    }

    private SaveParentDto getSaveParentDto() {
        return SaveParentDto.builder()
                .id(ANY_LONG)
                .email(CORRECT_EMAIL)
                .firstName(ANY_STRING)
                .phone(VALID_PHONE)
                .lastName(ANY_STRING)
                .schoolId(ANY_LONG)
                .secondName(ANY_STRING)
                .studentList(new ArrayList<>(Collections.singletonList(ANY_LONG)))
                .build();
    }

    private Parent getParent() {
        return Parent.builder()
                .id(ANY_LONG)
                .email(CORRECT_EMAIL)
                .firstName(ANY_STRING)
                .secondName(ANY_STRING)
                .lastName(ANY_STRING)
                .phone(VALID_PHONE)
                .school(School.builder().id(ANY_LONG).build())
                .studentList(new ArrayList<>(Collections.singletonList(Student.builder().id(ANY_LONG).build())))
                .build();
    }

    private ParentDto getParentDto() {
        return ParentDto.builder()
                .id(ANY_LONG)
                .email(CORRECT_EMAIL)
                .firstName(ANY_STRING)
                .secondName(ANY_STRING)
                .lastName(ANY_STRING)
                .phone(VALID_PHONE)
                .studentList(new ArrayList<>(Collections.singletonList(ANY_LONG)))
                .build();
    }

    private UpdateParentDto getUpdateParentDto() {
        return UpdateParentDto.builder().id(ANY_LONG).firstName(NAME).build();
    }
}
