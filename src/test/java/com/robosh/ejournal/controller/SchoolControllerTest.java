package com.robosh.ejournal.controller;

import com.robosh.ejournal.data.dto.school.SaveSchoolDto;
import com.robosh.ejournal.data.dto.school.SchoolInfoDto;
import com.robosh.ejournal.data.entity.SettlementType;
import com.robosh.ejournal.exception.ResourceNotFoundException;
import com.robosh.ejournal.service.SchoolService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.robosh.ejournal.data.DummyData.ANY_LONG;
import static com.robosh.ejournal.data.DummyData.ANY_STRING;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static util.TestUtil.asJsonString;

@WebMvcTest(SchoolController.class)
class SchoolControllerTest {

    private static final String SCHOOL_ENDPOINT = "/schools";
    private static final String GET_SCHOOL_ENDPOINT = SCHOOL_ENDPOINT.concat("/" + ANY_LONG);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SchoolService mockedSchoolService;

    @Test
    void should_ReturnHttpStatusCreated_When_SchoolServiceReturnDto() throws Exception {
        when(mockedSchoolService.save(getSaveSchoolDto())).thenReturn(getSchoolInfoDto());

        mockMvc.perform(MockMvcRequestBuilders
                .post(SCHOOL_ENDPOINT)
                .content(asJsonString(getSaveSchoolDto()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void should_ReturnSchoolInfoDto_When_SchoolServiceReturnDto() throws Exception {
        when(mockedSchoolService.findById(ANY_LONG)).thenReturn(getSchoolInfoDto());

        mockMvc.perform(MockMvcRequestBuilders
                .get(GET_SCHOOL_ENDPOINT))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ANY_LONG));
    }

    @Test
    void should_ReturnResponseStatusNotFound_When_SchoolServiceThrowResourceNotFoundException() throws Exception {
        when(mockedSchoolService.findById(ANY_LONG)).thenThrow(new ResourceNotFoundException(ANY_STRING, ANY_STRING, ANY_LONG));

        mockMvc.perform(MockMvcRequestBuilders
                .get(GET_SCHOOL_ENDPOINT))
                .andExpect(status().isNotFound());
    }

    private SaveSchoolDto getSaveSchoolDto() {
        return SaveSchoolDto.builder()
                .address(ANY_STRING)
                .name(ANY_STRING)
                .region(ANY_STRING)
                .settlementName(ANY_STRING)
                .settlementType(SettlementType.CITY)
                .url(ANY_STRING)
                .build();
    }

    private SchoolInfoDto getSchoolInfoDto() {
        return SchoolInfoDto.builder()
                .id(ANY_LONG)
                .address(ANY_STRING)
                .name(ANY_STRING)
                .region(ANY_STRING)
                .settlementName(ANY_STRING)
                .settlementType(SettlementType.CITY)
                .url(ANY_STRING)
                .build();
    }
}
