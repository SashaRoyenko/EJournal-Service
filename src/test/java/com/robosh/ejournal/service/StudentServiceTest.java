package com.robosh.ejournal.service;

import com.robosh.ejournal.config.BeanConfig;
import com.robosh.ejournal.data.dto.student.SaveStudentDto;
import com.robosh.ejournal.data.dto.student.StudentDto;
import com.robosh.ejournal.data.entity.Student;
import com.robosh.ejournal.data.repository.StudentRepository;
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
import java.util.Optional;

import static com.robosh.ejournal.data.DummyData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {
        StudentService.class,
        MapperConfiguration.class,
        BeanConfig.class,
        ValidationService.class
})
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository mockedStudentRepository;

    @MockBean
    private ValidationRepository mockedValidationRepository;

    @Test
    void should_ReturnStudentDto_When_GivenSaveStudentDto() {
        when(mockedValidationRepository.isUnique(any(), any(), any())).thenReturn(true);
        when(mockedStudentRepository.save(any())).thenReturn(getStudent());

        StudentDto expectedStudentDto = getStudentDto();
        StudentDto actualStudentDto = studentService.save(getSaveStudentDto());

        assertEquals(expectedStudentDto, actualStudentDto);
    }

    @Test
    void should_ReturnStudentDtoWithGivenId_When_StudentRepositoryReturnStudent() {
        Long expectedId = ANY_LONG;

        when(mockedStudentRepository.findById(expectedId)).thenReturn(Optional.of(getStudent()));

        Long actualId = studentService.findById(expectedId).getId();

        assertEquals(expectedId, actualId);
    }

    @Test
    void should_ThrowResourceNotFound_When_StudentRepositoryReturnNull() {
        when(mockedStudentRepository.findById(ANY_LONG)).thenReturn(Optional.ofNullable(null));

        assertThrows(ResourceNotFoundException.class, () -> studentService.findById(ANY_LONG));
    }

    @Test
    void should_ReturnUpdatedEntity_When_GivenDtoWithValidData() {
        SaveStudentDto updateDto = getUpdateStudentDto();
        Student updateStudent = getStudent();
        updateStudent.setFirstName(updateDto.getFirstName());
        StudentDto updatedStudent = getStudentDto();
        updatedStudent.setFirstName(updateDto.getFirstName());


        when(mockedStudentRepository.findById(ANY_LONG)).thenReturn(Optional.of(getStudent()));
        when(mockedStudentRepository.save(updateStudent)).thenReturn(updateStudent);

        assertEquals(updatedStudent, studentService.update(updateDto));
    }

    @Test
    void should_ThrowValidationException_When_GivenDtoWithInvalidData() {
        SaveStudentDto updateDto = getUpdateStudentDto();
        updateDto.setEmail(INCORRECT_EMAIL);

        when(mockedStudentRepository.findById(ANY_LONG)).thenReturn(Optional.of(getStudent()));

        assertThrows(ValidationException.class, () -> studentService.update(updateDto));
    }


    private Student getStudent() {
        return Student.builder()
                .email(CORRECT_EMAIL)
                .firstName(ANY_STRING)
                .secondName(ANY_STRING)
                .lastName(ANY_STRING)
                .id(ANY_LONG)
                .phone(VALID_PHONE)
                .school(ANY_SCHOOL)
                .password(PASSWORD)
                .group(ANY_GROUP)
                .parents(new ArrayList<>())
                .build();
    }

    private StudentDto getStudentDto() {
        return StudentDto.builder()
                .email(CORRECT_EMAIL)
                .firstName(ANY_STRING)
                .secondName(ANY_STRING)
                .parents(new ArrayList<>())
                .lastName(ANY_STRING)
                .id(ANY_LONG)
                .phone(VALID_PHONE)
                .group(ANY_GROUP_DTO)
                .build();
    }

    private SaveStudentDto getSaveStudentDto(){
        return SaveStudentDto.builder()
                .email(CORRECT_EMAIL)
                .firstName(ANY_STRING)
                .secondName(ANY_STRING)
                .groupId(ANY_LONG)
                .schoolId(ANY_LONG)
                .lastName(ANY_STRING)
                .id(ANY_LONG)
                .phone(VALID_PHONE)
                .password(PASSWORD)
                .build();
    }

    private SaveStudentDto getUpdateStudentDto(){
        return SaveStudentDto.builder()
                .id(ANY_LONG)
                .firstName(NAME)
                .build();
    }
}
