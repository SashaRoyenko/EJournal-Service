package com.robosh.ejournal.controller;

import com.robosh.ejournal.data.dto.student.SaveStudentDto;
import com.robosh.ejournal.data.dto.student.StudentDto;
import com.robosh.ejournal.data.entity.Student;
import com.robosh.ejournal.exception.ResourceNotFoundException;
import com.robosh.ejournal.exception.ValidationException;
import com.robosh.ejournal.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static com.robosh.ejournal.data.DummyData.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static util.TestUtil.asJsonString;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    private static final String STUDENT_ENDPOINT = "/students";
    private static final String GET_STUDENT_ENDPOINT = STUDENT_ENDPOINT.concat("/" + ANY_LONG);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService mockedStudentService;

    @Test
    void should_returnResponseStatusSavedWithSimilarData_When_SaveStudentDtoIsCorrect() throws Exception {
        SaveStudentDto saveStudentDto = getSaveStudentDto();
        StudentDto studentDto = getStudentDto();

        when(mockedStudentService.save(saveStudentDto)).thenReturn(studentDto);

        mockMvc.perform(MockMvcRequestBuilders
                .post(STUDENT_ENDPOINT)
                .content(asJsonString(saveStudentDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(ANY_LONG));
    }

    @Test
    void should_returnStudentDto_When_StudentServiceReturnData() throws Exception {
        StudentDto studentDto = getStudentDto();

        when(mockedStudentService.findById(ANY_LONG)).thenReturn(studentDto);

        mockMvc.perform(MockMvcRequestBuilders
                .get(GET_STUDENT_ENDPOINT))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ANY_LONG));
    }

    @Test
    void should_ReturnResponseStatusNotFound_When_StudentServiceThrowResourceNotFound() throws Exception {
        when(mockedStudentService.findById(ANY_LONG)).thenThrow(ResourceNotFoundException.class);

        mockMvc.perform(MockMvcRequestBuilders
                .get(GET_STUDENT_ENDPOINT))
                .andExpect(status().isNotFound());
    }

    @Test
    void should_ReturnResponseStatusBadRequest_When_GivenStudentWithInvalidPhoneNumber() throws Exception {
        SaveStudentDto saveStudentDtoInvalidPhone = getSaveStudentDto();
        StudentDto studentDtoInvalidPhone = getStudentDto();
        saveStudentDtoInvalidPhone.setPhone(ANY_STRING);
        studentDtoInvalidPhone.setPhone(ANY_STRING);

        when(mockedStudentService.save(saveStudentDtoInvalidPhone)).thenThrow(ValidationException.class);
        mockMvc.perform(MockMvcRequestBuilders
                .post(STUDENT_ENDPOINT))
                .andExpect(status().isBadRequest());
    }

    private SaveStudentDto getSaveStudentDto() {
        return SaveStudentDto.builder()
                .email(CORRECT_EMAIL)
                .firstName(ANY_STRING)
                .secondName(ANY_STRING)
                .groupId(ANY_LONG)
                .phone(VALID_PHONE)
                .schoolId(ANY_LONG)
                .lastName(ANY_STRING)
                .id(ANY_LONG)
                .password(PASSWORD)
                .build();
    }

    private StudentDto getStudentDto() {
        return StudentDto.builder()
                .email(CORRECT_EMAIL)
                .firstName(ANY_STRING)
                .secondName(ANY_STRING)
                .parents(new ArrayList<>())
                .lastName(ANY_STRING)
                .phone(VALID_PHONE)
                .id(ANY_LONG)
                .group(ANY_GROUP_DTO)
                .build();
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

}