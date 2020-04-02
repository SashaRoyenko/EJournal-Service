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
