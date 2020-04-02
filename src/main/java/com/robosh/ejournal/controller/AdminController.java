package com.robosh.ejournal.controller;

import com.robosh.ejournal.data.dto.admin.AdminInfoDto;
import com.robosh.ejournal.data.dto.admin.UpdateAdminDto;
import com.robosh.ejournal.service.AdminService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<AdminInfoDto> saveAdmin(@ApiParam @Valid @RequestBody UpdateAdminDto updateAdminDto){
        AdminInfoDto adminDto = adminService.save(updateAdminDto);
        return new ResponseEntity<>(adminDto, HttpStatus.CREATED);
    }
}
