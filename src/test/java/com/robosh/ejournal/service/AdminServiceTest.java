package com.robosh.ejournal.service;

import com.robosh.ejournal.data.dto.admin.AdminInfoDto;
import com.robosh.ejournal.data.dto.admin.UpdateAdminDto;
import com.robosh.ejournal.data.entity.admin.Admin;
import com.robosh.ejournal.data.entity.admin.AdminRole;
import com.robosh.ejournal.data.repository.AdminRepository;
import config.MapperConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ValidationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {
        AdminService.class,
        MapperConfiguration.class
})
class AdminServiceTest {

    @Autowired
    private AdminService adminService;

    @MockBean
    private AdminRepository adminRepository;

    @Test
    void Should_SaveAdmin_WhenDataValid() {
        when(adminRepository.save(any())).thenReturn(getAdmin());

        UpdateAdminDto adminToSave = getUpdateAdminDto();
        AdminInfoDto result = adminService.save(adminToSave);
        AdminInfoDto expected = getAdminInfoDto();

        assertEquals(expected, result);
        verify(adminRepository).save(any());
    }

    @Test
    void Should_ThrowValidationException_WhenPasswordNotEquals_ForSaveAdmin() {
        UpdateAdminDto adminToSave = getUpdateAdminDto();
        adminToSave.setConfirmedPassword("notsamepassword");
        ValidationException validationException = assertThrows(ValidationException.class, () -> adminService.save(adminToSave));
        assertEquals("Password should be same", validationException.getMessage());

    }

    private Admin getAdmin() {
        return Admin.builder()
                .firstName("TestAdminName")
                .lastName("LastAdminName")
                .adminRole(AdminRole.ADMIN)
                .email("testemail@test.com")
                .password("password")
                .build();
    }

    private AdminInfoDto getAdminInfoDto() {
        return AdminInfoDto.builder()
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