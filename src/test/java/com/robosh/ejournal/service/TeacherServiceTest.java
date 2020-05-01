package com.robosh.ejournal.service;

import com.robosh.ejournal.config.BeanConfig;
import com.robosh.ejournal.data.dto.teacher.SaveTeacherDto;
import com.robosh.ejournal.data.dto.teacher.TeacherDto;
import com.robosh.ejournal.data.entity.Group;
import com.robosh.ejournal.data.entity.School;
import com.robosh.ejournal.data.entity.Teacher;
import com.robosh.ejournal.data.repository.TeacherRepository;
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

import java.util.Optional;

import static com.robosh.ejournal.data.DummyData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {
        MapperConfiguration.class,
        BeanConfig.class,
        ValidationService.class,
        TeacherService.class
})
class TeacherServiceTest {
    @Autowired
    private TeacherService teacherService;

    @MockBean
    private TeacherRepository mockedTeacherRepository;

    @MockBean
    private ValidationRepository mockedValidationRepository;

    @Test
    void should_ReturnTeacherDto_When_GivenValidSaveDto() {
        when(mockedTeacherRepository.save(any())).thenReturn(getTeacher());

        assertEquals(getTeacherDto(), teacherService.save(getSaveTeacherDto()));
    }

    @Test
    void should_ThrowValidationException_When_GivenInvalidSaveDto() {
        SaveTeacherDto invalidDto = getSaveTeacherDto();
        invalidDto.setEmail(INCORRECT_EMAIL);

        assertThrows(ValidationException.class, () -> teacherService.save(invalidDto));
    }

    @Test
    void should_ReturnEntityWithSameId_When_RepositoryReturnEntity() {
        when(mockedTeacherRepository.findById(ANY_LONG)).thenReturn(Optional.of(getTeacher()));

        assertEquals(ANY_LONG, teacherService.findById(ANY_LONG).getId());
    }

    @Test
    void should_ThrowResourceNotFoundException_When_RepositoryReturnNull() {
        when(mockedTeacherRepository.findById(ANY_LONG)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> teacherService.findById(ANY_LONG));
    }

    @Test
    void should_ReturnUpdatedEntity_When_GivenCorrectDto() {
        SaveTeacherDto updateDto = getUpdateDto();
        TeacherDto updatedTeacherDto = getTeacherDto();
        updatedTeacherDto.setFirstName(updateDto.getFirstName());
        Teacher updatedTeacher = getTeacher();
        updatedTeacher.setFirstName(updateDto.getFirstName());

        when(mockedTeacherRepository.findById(ANY_LONG)).thenReturn(Optional.of(getTeacher()));
        when(mockedTeacherRepository.save(updatedTeacher)).thenReturn(updatedTeacher);

        assertEquals(updatedTeacherDto, teacherService.updateTeacher(updateDto));
    }

    @Test
    void should_ThrowResourceNotFoundException_When_GivenUnexcitingIdAndRepositoryReturnNull() {
        when(mockedTeacherRepository.findById(ANY_LONG)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> teacherService.updateTeacher(getUpdateDto()));
    }

    @Test
    void should_ThrowValidationException_When_GivenInvalidUpdateDto() {
        SaveTeacherDto invalidDto = getUpdateDto();
        invalidDto.setFirstName(EMPTY_STRING);

        when(mockedTeacherRepository.findById(ANY_LONG)).thenReturn(Optional.of(getTeacher()));

        assertThrows(ValidationException.class, () -> teacherService.updateTeacher(invalidDto));
    }

    private TeacherDto getTeacherDto() {
        return TeacherDto.builder()
                .description(ANY_STRING)
                .email(CORRECT_EMAIL)
                .firstName(ANY_STRING)
                .id(ANY_LONG)
                .secondName(ANY_STRING)
                .lastName(ANY_STRING)
                .phone(VALID_PHONE)
                .groupId(ANY_LONG)
                .schoolId(ANY_LONG)
                .build();
    }

    private Teacher getTeacher() {
        return Teacher.builder()
                .description(ANY_STRING)
                .email(CORRECT_EMAIL)
                .firstName(ANY_STRING)
                .id(ANY_LONG)
                .secondName(ANY_STRING)
                .lastName(ANY_STRING)
                .phone(VALID_PHONE)
                .group(Group.builder().id(ANY_LONG).build())
                .school(School.builder().id(ANY_LONG).build())
                .build();
    }

    private SaveTeacherDto getSaveTeacherDto() {
        return SaveTeacherDto.builder()
                .description(ANY_STRING)
                .email(CORRECT_EMAIL)
                .firstName(ANY_STRING)
                .id(ANY_LONG)
                .secondName(ANY_STRING)
                .lastName(ANY_STRING)
                .phone(VALID_PHONE)
                .groupId(ANY_LONG)
                .schoolId(ANY_LONG)
                .build();
    }

    private SaveTeacherDto getUpdateDto() {
        return SaveTeacherDto.builder()
                .id(ANY_LONG)
                .firstName(NAME)
                .build();
    }
}