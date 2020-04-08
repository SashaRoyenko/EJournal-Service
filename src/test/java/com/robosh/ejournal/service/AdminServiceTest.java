package com.robosh.ejournal.service;

import com.robosh.ejournal.data.dto.admin.AdminInfoDto;
import com.robosh.ejournal.data.dto.admin.SaveAdminDto;
import com.robosh.ejournal.data.entity.admin.Admin;
import com.robosh.ejournal.data.entity.admin.AdminRole;
import com.robosh.ejournal.data.repository.AdminRepository;
import com.robosh.ejournal.exception.ResourceNotFoundException;
import config.MapperConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.robosh.ejournal.data.DummyData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {
        AdminService.class,
        MapperConfiguration.class,
        ModelMapper.class
})
class AdminServiceTest {

    @Autowired
    private AdminService adminService;

    @MockBean
    private AdminRepository mockedAdminRepository;

    private List<Admin> adminsList;

    @Test
    void Should_ReturnAdminInfoDTOsList_When_GetAllAdmins() {
        givenAdmins();
        whenGetAllAdmins();
        thenShouldReturn();
    }

    @Test
    void Should_ReturnAdminInfoDtoById_When_FindById() {
        when(mockedAdminRepository.findById(any())).thenReturn(Optional.of(getAdmin()));

        AdminInfoDto expected= getAdminInfoDto();
        AdminInfoDto actual = adminService.findById(anyLong());
        assertEquals(expected, actual);
    }

    @Test
    void Should_ThrowResourceNotFoundException_WhenAdminNotFound_ForFindById() {
        ResourceNotFoundException resourceNotFoundException =
                assertThrows(ResourceNotFoundException.class, () -> adminService.findById(any()));
        assertEquals("Admin not found with id : 'null'", resourceNotFoundException.getMessage());
    }

    @Test
    void Should_SaveAdmin_When_DataValid() {
        when(mockedAdminRepository.save(any())).thenReturn(getAdmin());

        SaveAdminDto adminToSave = getSaveAdminDto();
        AdminInfoDto result = adminService.save(adminToSave);
        AdminInfoDto expected = getAdminInfoDto();

        assertEquals(expected, result);
        verify(mockedAdminRepository).save(any());
    }

    @Test
    void Should_UpdateAdmin_WhenDataValid() {
        when(mockedAdminRepository.findById(any())).thenReturn(Optional.of(getAdmin()));
        when(mockedAdminRepository.save(any())).thenReturn(getAdmin());

        SaveAdminDto adminToSave = getSaveAdminDto();
        AdminInfoDto result = adminService.update(adminToSave);
        AdminInfoDto expected = getAdminInfoDto();

        assertEquals(expected, result);
        verify(mockedAdminRepository).save(any());
    }

    private void whenGetAllAdmins() {
        when(mockedAdminRepository.findAll()).thenReturn(adminsList);
    }

    private void thenShouldReturn() {
        List<AdminInfoDto> actualAdminDTOS = adminService.findAll();
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
                                .email(EMPTY_STRING)
                                .firstName(EMPTY_STRING)
                                .id(ANY_LONG)
                                .lastName(EMPTY_STRING)
                                .build(),
                        Admin.builder()
                                .adminRole(AdminRole.SUPER_ADMIN)
                                .email(EMPTY_STRING)
                                .firstName(EMPTY_STRING)
                                .id(ANY_LONG)
                                .lastName(EMPTY_STRING)
                                .build()
                )
        );
    }

    private List<AdminInfoDto> getExpectedAdminInfoDTOs() {
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

    private Admin getAdmin() {
        return Admin.builder()
                .firstName(NAME)
                .lastName(NAME)
                .adminRole(AdminRole.ADMIN)
                .email(EMAIL)
                .password(PASSWORD)
                .school(ANY_SCHOOL)
                .build();
    }

    private AdminInfoDto getAdminInfoDto() {
        return AdminInfoDto.builder()
                .firstName(NAME)
                .lastName(NAME)
                .adminRole(AdminRole.ADMIN)
                .email(EMAIL)
                .school(ANY_SCHOOL_DTO)
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
