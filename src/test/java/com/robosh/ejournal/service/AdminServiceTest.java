package com.robosh.ejournal.service;

import com.robosh.ejournal.data.dto.admin.AdminInfoDTO;
import com.robosh.ejournal.data.entity.admin.Admin;
import com.robosh.ejournal.data.entity.admin.AdminRole;
import com.robosh.ejournal.data.mapping.admin.AdminDTOMapper;
import com.robosh.ejournal.data.mapping.admin.AdminMapper;
import com.robosh.ejournal.data.mapping.admin.AdminMapperImpl;
import com.robosh.ejournal.data.repository.AdminRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {
                AdminService.class,
                AdminMapperImpl.class
        }
)
class AdminServiceTest {

    @MockBean
    private AdminRepository mockedAdminRepository;

    @Autowired
    private AdminService adminService;

    private List<Admin> adminsList;

    private List<AdminInfoDTO> actualAdminDTOS;

    @Test
    void whenGetAllAdmins_givenAdminsList_thenShouldReturnAdminInfoDTOsList() {
        givenAdmins();
        whenGetAllAdmins();
        thenShouldReturn();
    }

    private void whenGetAllAdmins() {
        when(mockedAdminRepository.findAll()).thenReturn(adminsList);
    }

    private void thenShouldReturn() {
        actualAdminDTOS = adminService.getAllAdmins();
        assertEquals(getExpectedAdminInfoDTOs(), actualAdminDTOS);
    }

    private void givenAdmins() {
        adminsList = getAdmins();
    }

    private List<Admin> getAdmins() {
        return new ArrayList<>(
                Arrays.asList(
                        Admin.builder()
                                .adminRole(AdminRole.ADMIN)
                                .email("")
                                .firstName("")
                                .id(1L)
                                .lastName("")
                                .build(),
                        Admin.builder()
                                .adminRole(AdminRole.SUPER_ADMIN)
                                .email("")
                                .firstName("")
                                .id(2L)
                                .lastName("")
                                .build()

                )
        );
    }

    private List<AdminInfoDTO> getExpectedAdminInfoDTOs(){
        return new ArrayList<>(
                Arrays.asList(
                        AdminInfoDTO.builder()
                                .adminRole(AdminRole.ADMIN)
                                .email("")
                                .firstName("")
                                .id(1L)
                                .lastName("")
                                .build(),
                        AdminInfoDTO.builder()
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