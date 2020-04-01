package com.robosh.ejournal.controller;

import com.robosh.ejournal.data.dto.admin.AdminInfoDto;
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

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AdminController.class)
class AdminControllerTest {

    private static final String ADMINS_ENDPOINT = "/admins";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminService mockedAdminService;

    private List<AdminInfoDto> adminsList;

    @Test
    void whenGetAll_givenAdminInfoDTOsList_thenShouldReturnAdminInfoDTOsList() throws Exception {
        givenAdmins();
        whenGetAllAdmins();
        thenShouldReturn();

    }

    private void whenGetAllAdmins() {
        when(mockedAdminService.getAllAdmins()).thenReturn(adminsList);
    }

    private void thenShouldReturn() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get(ADMINS_ENDPOINT)
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
                                .email("")
                                .firstName("")
                                .id(1L)
                                .lastName("")
                                .build(),
                        AdminInfoDto.builder()
                                .adminRole(AdminRole.SUPER_ADMIN)
                                .email("")
                                .firstName("")
                                .id(2L)
                                .lastName("")
                                .build()

                )
        );
    }


}