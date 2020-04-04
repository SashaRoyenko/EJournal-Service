package com.robosh.ejournal.service;

import com.robosh.ejournal.data.dto.student.SaveStudentDto;
import com.robosh.ejournal.data.dto.student.StudentDto;
import com.robosh.ejournal.data.entity.Student;
import com.robosh.ejournal.data.mapping.StudentMapper;
import com.robosh.ejournal.data.repository.StudentRepository;
import config.MapperConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

import static com.robosh.ejournal.data.DummyData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {
        StudentService.class,
        MapperConfiguration.class,
})
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository mockedStudentRepository;

    private StudentDto expectedStudentDto;

    @Test
    void should_ReturnStudentDto_whenGivenSaveStudentDto() {
        when(mockedStudentRepository.save(getStudent())).thenReturn(getStudent());
        expectedStudentDto = getStudentDto();
        System.out.println(getStudent());
        System.out.println(Mappers.getMapper(StudentMapper.class).fromStudentSaveDtoToStudent(getSaveStudentDto()));
        assertEquals(expectedStudentDto, studentService.save(getSaveStudentDto()));
    }

    private Student getStudent() {
        return Student.builder()
                .email(EMAIL)
                .firstName(ANY_STRING)
                .secondName(ANY_STRING)
                .lastName(ANY_STRING)
                .id(ANY_LONG)
                .school(ANY_SCHOOL)
                .password(PASSWORD)
                .group(ANY_GROUP)
                .parents(new ArrayList<>())
                .build();
    }

    private StudentDto getStudentDto(){
        return StudentDto.builder()
                .email(EMAIL)
                .firstName(ANY_STRING)
                .secondName(ANY_STRING)
                .parents(new ArrayList<>())
                .lastName(ANY_STRING)
                .id(ANY_LONG)
                .group(ANY_GROUP_DTO)
                .build();
    }

    private SaveStudentDto getSaveStudentDto(){
        return SaveStudentDto.builder()
                .email(EMAIL)
                .firstName(ANY_STRING)
                .secondName(ANY_STRING)
                .groupId(ANY_LONG)
                .schoolId(ANY_LONG)
                .lastName(ANY_STRING)
                .id(ANY_LONG)
                .password(PASSWORD)
                .build();
    }
}