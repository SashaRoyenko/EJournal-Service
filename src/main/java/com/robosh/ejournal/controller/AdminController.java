package com.robosh.ejournal.controller;

import com.robosh.ejournal.data.dto.admin.AdminInfoDto;
import com.robosh.ejournal.data.dto.admin.UpdateAdminDto;
import com.robosh.ejournal.service.AdminService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @ApiOperation(value = "Update admin")
    @PutMapping("/{id}")
    public ResponseEntity<AdminInfoDto> updateAdmin(@ApiParam @Valid @RequestBody UpdateAdminDto updateAdminDto){
        AdminInfoDto adminDto = adminService.save(updateAdminDto);
        return new ResponseEntity<>(adminDto, HttpStatus.OK);
    }

    @ApiOperation(value = "Returns all admins")
    @GetMapping
    public List<AdminInfoDto> getAllAdmins() {
        return adminService.findAll();
    }
}
