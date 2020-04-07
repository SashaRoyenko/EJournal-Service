package com.robosh.ejournal.controller;

import com.robosh.ejournal.data.dto.admin.AdminInfoDto;
import com.robosh.ejournal.data.dto.admin.SaveAdminDto;
import com.robosh.ejournal.data.entity.admin.AdminRole;
import com.robosh.ejournal.service.AdminService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.robosh.ejournal.data.DummyData.*;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static util.TestUtil.asJsonString;

@WebMvcTest(AdminController.class)
class AdminControllerTest {

    private static final String ADMIN_ENDPOINT = "/admins";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminService mockedAdminService;

    private List<AdminInfoDto> adminsList;

    @Test
<<<<<<< HEAD
    void Should_executeEndpointToSaveAdminAndReturnNewAdminData_WhenDataIsValid() throws Exception {
=======
    void Should_executeEndpointToSaveAdminAndReturnNewAdminData_When_DataIsValid() throws Exception {
>>>>>>> ed1c672626d373de2458e9f246609d95572cc894
        SaveAdminDto saveAdminDto = getSaveAdminDto();
        AdminInfoDto adminInfoDto = getAdminInfoDto();

        when(mockedAdminService.save(saveAdminDto)).thenReturn(adminInfoDto);

        mockMvc.perform(MockMvcRequestBuilders
                .post(ADMIN_ENDPOINT)
<<<<<<< HEAD
                .content(asJsonString(getSaveAdminDto()))
=======
                .content(asJsonString(saveAdminDto))
>>>>>>> ed1c672626d373de2458e9f246609d95572cc894
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value(NAME))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value(NAME))
                .andExpect(MockMvcResultMatchers.jsonPath("$.adminRole").value("ADMIN"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(EMAIL));
    }

    @Test
    void  Should_executeEndpointToUpdateAdminAndReturnNewAdminData_WhenDataIsValid() throws Exception{
        SaveAdminDto saveAdminDto = getSaveAdminDto();
        AdminInfoDto adminInfoDto = getAdminInfoDto();

        when(mockedAdminService.update(saveAdminDto)).thenReturn(adminInfoDto);

        mockMvc.perform(MockMvcRequestBuilders
                .put(ADMIN_ENDPOINT)
                .content(asJsonString(getSaveAdminDto()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value(NAME))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value(NAME))
                .andExpect(MockMvcResultMatchers.jsonPath("$.adminRole").value("ADMIN"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(EMAIL));
    }

    @Test
    void Should_ReturnAdminsInfoDtoListJSON_When_GetAllAdminsInfoDto() throws Exception {
        givenAdmins();
        whenGetAllAdmins();
        thenShouldReturn();
    }

    private void whenGetAllAdmins() {
        when(mockedAdminService.findAll()).thenReturn(adminsList);
    }

    private void thenShouldReturn() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get(ADMIN_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(adminsList.size())));
    }

    private void givenAdmins() {
        adminsList = getAdminInfoDTOs();
    }

    private List<AdminInfoDto> getAdminInfoDTOs() {
        return new ArrayList<>(
                Arrays.asList(
                        AdminInfoDto.builder()
                                .adminRole(AdminRole.ADMIN)
                                .email(EMPTY_STRING)
                                .firstName(EMPTY_STRING)
                                .id(ANY_LONG)
                                .lastName(EMPTY_STRING)
                                .build(),
                        AdminInfoDto.builder()
                                .adminRole(AdminRole.SUPER_ADMIN)
                                .email(EMPTY_STRING)
                                .firstName(EMPTY_STRING)
                                .id(ANY_LONG)
                                .lastName(EMPTY_STRING)
                                .build()
                )
        );
    }

    private AdminInfoDto getAdminInfoDto() {
        return AdminInfoDto.builder()
                .id(ANY_LONG)
                .firstName(NAME)
                .lastName(NAME)
                .adminRole(AdminRole.ADMIN)
                .email(EMAIL)
                .build();
    }

    private SaveAdminDto getSaveAdminDto() {
        return SaveAdminDto.builder()
                .firstName(NAME)
                .lastName(NAME)
                .adminRole(AdminRole.ADMIN)
                .email(EMAIL)
                .password(PASSWORD)
                .confirmedPassword(PASSWORD)
                .schoolId(ANY_LONG)
                .build();
    }
}
