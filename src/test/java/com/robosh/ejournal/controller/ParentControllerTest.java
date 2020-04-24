package com.robosh.ejournal.controller;

import com.robosh.ejournal.data.dto.parent.ParentDto;
import com.robosh.ejournal.data.dto.parent.SaveParentDto;
import com.robosh.ejournal.data.dto.parent.UpdateParentDto;
import com.robosh.ejournal.exception.ResourceNotFoundException;
import com.robosh.ejournal.exception.ValidationException;
import com.robosh.ejournal.service.ParentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.Collections;

import static com.robosh.ejournal.data.DummyData.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static util.TestUtil.asJsonString;

@WebMvcTest(ParentController.class)
class ParentControllerTest {

    private final String PARENT_ENDPOINT = "/parents";
    private final String GET_PARENT_BY_ID_ENDPOINT = PARENT_ENDPOINT.concat("/" + ANY_LONG);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ParentService mockedParentService;

    @Test
    void should_ReturnResponseStatusCreated_When_ServiceReturnEntity() throws Exception {
        when(mockedParentService.save(getSaveParentDto())).thenReturn(getParentDto());

        mockMvc.perform(MockMvcRequestBuilders
                .post(PARENT_ENDPOINT)
                .content(asJsonString(getSaveParentDto()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void should_ReturnStatusBadRequest_When_GivenDtoWithoutStudents() throws Exception {
        SaveParentDto invalidDto = getSaveParentDto();
        invalidDto.setStudentList(null);

        mockMvc.perform(MockMvcRequestBuilders
                .post(PARENT_ENDPOINT)
                .content(asJsonString(invalidDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_ReturnResponseStatusBadRequest_When_ServiceSaveThrowValidationException() throws Exception {
        when(mockedParentService.save(getSaveParentDto())).thenThrow(ValidationException.class);

        mockMvc.perform(MockMvcRequestBuilders
                .post(PARENT_ENDPOINT)
                .content(asJsonString(getSaveParentDto()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_ReturnResponseStatusOk_When_ServiceReturnEntity() throws Exception {
        when(mockedParentService.update(getUpdateParentDto())).thenReturn(getParentDto());

        mockMvc.perform(MockMvcRequestBuilders
                .put(PARENT_ENDPOINT)
                .content(asJsonString(getUpdateParentDto()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void should_ReturnResponseStatusBadRequest_When_GivenDtoWithNotSamePasswords() throws Exception {
        UpdateParentDto updateParentDto = getUpdateParentDto();
        updateParentDto.setPassword(PASSWORD);
        updateParentDto.setConfirmedPassword(EMPTY_STRING);

        mockMvc.perform(MockMvcRequestBuilders
                .put(PARENT_ENDPOINT)
                .content(asJsonString(updateParentDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_ReturnResponseStatusBadRequest_When_ServiceUpdateThrowValidationException() throws Exception {
        when(mockedParentService.update(getUpdateParentDto())).thenThrow(ValidationException.class);

        mockMvc.perform(MockMvcRequestBuilders
                .put(PARENT_ENDPOINT)
                .content(asJsonString(getUpdateParentDto()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_ReturnResponseStatusNotFound_When_ServiceUpdateThrowResourceNotFoundException() throws Exception {
        when(mockedParentService.update(getUpdateParentDto())).thenThrow(ResourceNotFoundException.class);

        mockMvc.perform(MockMvcRequestBuilders
                .put(PARENT_ENDPOINT)
                .content(asJsonString(getUpdateParentDto()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void should_ReturnResponseStatusOkAndEntity_When_ServiceReturnEntity() throws Exception {
        when(mockedParentService.findById(ANY_LONG)).thenReturn(getParentDto());

        mockMvc.perform(MockMvcRequestBuilders
                .get(GET_PARENT_BY_ID_ENDPOINT))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ANY_LONG));

    }

    @Test
    void should_ReturnResponseStatusNotFound_When_ServiceThrowResourceNotFoundException() throws Exception {
        when(mockedParentService.findById(ANY_LONG)).thenThrow(ResourceNotFoundException.class);

        mockMvc.perform(MockMvcRequestBuilders
                .get(GET_PARENT_BY_ID_ENDPOINT))
                .andExpect(status().isNotFound());
    }
    @Test
    void should_ReturnResponseStatusCreated_When_ServiceFindAllBySchoolIdReturnEntity() throws Exception {
        when(mockedParentService.findAllBySchoolId(ANY_LONG, 0, 1))
                .thenReturn(new ArrayList<>(Collections.singletonList(getParentDto())));

        mockMvc.perform(MockMvcRequestBuilders
                .get(PARENT_ENDPOINT)
                .params(getParams())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
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

    private MultiValueMap<String, String> getParams() {
        MultiValueMap <String, String> params = new HttpHeaders();
        params.add("id", ANY_LONG.toString());
        params.add("size", "1");
        params.add("page", "0");
        return params;
    }
}
