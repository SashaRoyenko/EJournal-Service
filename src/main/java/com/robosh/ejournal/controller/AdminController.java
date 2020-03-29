package com.robosh.ejournal.controller;

import com.robosh.ejournal.dto.AdminDto;
import com.robosh.ejournal.entity.admin.AdminRole;
import com.robosh.ejournal.service.AdminService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/admins")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @ApiOperation(value = "Add an admin")
    @PostMapping
    public ResponseEntity<String> saveAdmin(@ApiParam @Valid @RequestBody AdminDto adminDto){
        adminService.save(adminDto);
        return ResponseEntity.ok("Saved");
    }

    @PostMapping("/supers")
    public void createSuperAdmin(){
        AdminDto adminDto = AdminDto.builder()
                .firstName("SuperAdmin")
                .lastName("SuperAdmin")
                .password("superadmin")
                .confirmedPassword("superadmin")
                .email("superadmin@gmail.com")
                .adminRole(AdminRole.SUPER_ADMIN)
                .build();
        adminService.save(adminDto);
    }
}
