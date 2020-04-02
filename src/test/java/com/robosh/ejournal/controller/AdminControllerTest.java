package com.robosh.ejournal.controller;

import com.robosh.ejournal.data.dto.admin.AdminInfoDto;
import com.robosh.ejournal.data.dto.admin.UpdateAdminDto;
import com.robosh.ejournal.data.entity.admin.AdminRole;
import com.robosh.ejournal.service.AdminService;
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

import static com.robosh.ejournal.data.DummyData.ANY_LONG;
import static com.robosh.ejournal.data.DummyData.EMPTY_STRING;
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
    void Should_executeEndpointToSaveAdminAndReturnNewAdminData_WhenDataIsValid() throws Exception {
        UpdateAdminDto updateAdminDto = getUpdateAdminDto();
        AdminInfoDto adminInfoDto = getAdminInfoDto();

        when(mockedAdminService.save(updateAdminDto)).thenReturn(adminInfoDto);

        mockMvc.perform(MockMvcRequestBuilders
                .post(ADMIN_ENDPOINT)
                .content(asJsonString(getUpdateAdminDto()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("TestAdminName"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("LastAdminName"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.adminRole").value("ADMIN"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("testemail@test.com"));
    }

    @Test
    void Should_ReturnAdminsInfoDtoListJSON_When_GetAllAdminsInfoDto() throws Exception {
        givenAdmins();
        whenGetAllAdmins();
        thenShouldReturn();
    }

    private void whenGetAllAdmins() {
        when(mockedAdminService.getAllAdmins()).thenReturn(adminsList);
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
                .id(1L)
                .firstName("TestAdminName")
                .lastName("LastAdminName")
                .adminRole(AdminRole.ADMIN)
                .email("testemail@test.com")
                .build();
    }

    private UpdateAdminDto getUpdateAdminDto() {
        return UpdateAdminDto.builder()
                .firstName("TestAdminName")
                .lastName("LastAdminName")
                .adminRole(AdminRole.ADMIN)
                .email("testemail@test.com")
                .password("password")
                .confirmedPassword("password")
                .schoolId(1L)
                .build();
    }
}
