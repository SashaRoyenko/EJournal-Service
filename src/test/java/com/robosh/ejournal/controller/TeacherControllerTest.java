package com.robosh.ejournal.controller;

import com.robosh.ejournal.data.dto.teacher.SaveTeacherDto;
import com.robosh.ejournal.data.dto.teacher.TeacherDto;
import com.robosh.ejournal.exception.ResourceNotFoundException;
import com.robosh.ejournal.exception.ValidationException;
import com.robosh.ejournal.service.TeacherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.robosh.ejournal.data.DummyData.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static util.TestUtil.asJsonString;

@WebMvcTest(TeacherController.class)
class TeacherControllerTest {
    private final String TEACHER_ENDPOINT = "/teachers";
    private final String FIND_TEACHER_BY_ID = TEACHER_ENDPOINT.concat("/" + ANY_LONG);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeacherService teacherService;

    @Test
    void should_ReturnResponseStatusCreated_When_ServiceReturnEntity() throws Exception {
        when(teacherService.save(getSaveTeacherDto())).thenReturn(getTeacherDto());

        mockMvc.perform(MockMvcRequestBuilders
                .post(TEACHER_ENDPOINT)
                .content(asJsonString(getSaveTeacherDto()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void should_ReturnResponseStatusBadRequest_When_ServiceThrowValidationExceptionOnSave() throws Exception {
        when(teacherService.save(any())).thenThrow(new ValidationException());

        mockMvc.perform(MockMvcRequestBuilders
                .post(TEACHER_ENDPOINT)
                .content(asJsonString(getSaveTeacherDto()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_ReturnResponseStatusOkAndEntityWithSameId_When_ServiceReturnEntity() throws Exception {
        when(teacherService.findById(ANY_LONG)).thenReturn(getTeacherDto());

        mockMvc.perform(MockMvcRequestBuilders
                .get(FIND_TEACHER_BY_ID))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ANY_LONG));
    }

    @Test
    void should_ReturnResponseStatusNotFound_When_ServiceThrowResourceNotFoundException() throws Exception {
        when(teacherService.findById(ANY_LONG)).thenThrow(ResourceNotFoundException.class);

        mockMvc.perform(MockMvcRequestBuilders
                .get(FIND_TEACHER_BY_ID))
                .andExpect(status().isNotFound());
    }

    @Test
    void should_ReturnResponseStatusOk_When_ServiceReturnUpdatedEntity() throws Exception {
        when(teacherService.updateTeacher(getUpdateDto())).thenReturn(getTeacherDto());

        mockMvc.perform(MockMvcRequestBuilders
                .put(TEACHER_ENDPOINT)
                .content(asJsonString(getUpdateDto()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void should_ReturnResponseStatusNotFound_When_ServiceThrowResourceNotFoundExceptionOnUpdate() throws Exception {
        when(teacherService.updateTeacher(any())).thenThrow(ResourceNotFoundException.class);

        mockMvc.perform(MockMvcRequestBuilders
                .put(TEACHER_ENDPOINT)
                .content(asJsonString(getUpdateDto()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void should_ReturnResponseStatusBadRequest_When_ServiceThrowValidationException() throws Exception {
        when(teacherService.updateTeacher(any())).thenThrow(ValidationException.class);

        mockMvc.perform(MockMvcRequestBuilders
                .put(TEACHER_ENDPOINT)
                .content(asJsonString(getUpdateDto()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_ReturnResponseStatusBadRequest_When_GivenDtoWithNotSamePasswords() throws Exception {
        SaveTeacherDto updateDto = getUpdateDto();
        updateDto.setPassword(PASSWORD);
        updateDto.setConfirmedPassword(EMPTY_STRING);

        mockMvc.perform(MockMvcRequestBuilders
                .put(TEACHER_ENDPOINT)
                .content(asJsonString(updateDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
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