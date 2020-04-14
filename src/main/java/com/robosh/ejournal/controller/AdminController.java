package com.robosh.ejournal.controller;

import com.robosh.ejournal.data.dto.admin.AdminInfoDto;
import com.robosh.ejournal.data.dto.admin.SaveAdminDto;
import com.robosh.ejournal.service.AdminService;
import com.robosh.ejournal.util.validation.ValidatorProcessor;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admins")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @ApiOperation(value = "Add an admin")
    @PostMapping
    public ResponseEntity<AdminInfoDto> saveAdmin(@ApiParam @RequestBody SaveAdminDto saveAdminDto){
        ValidatorProcessor.validate(saveAdminDto);
        AdminInfoDto adminDto = adminService.save(saveAdminDto);
        return new ResponseEntity<>(adminDto, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update admin")
    @PutMapping
    public ResponseEntity<AdminInfoDto> updateAdmin(@ApiParam @RequestBody SaveAdminDto updateAdminDto){
        ValidatorProcessor.validate(updateAdminDto);
        AdminInfoDto adminDto = adminService.update(updateAdminDto);
        return new ResponseEntity<>(adminDto, HttpStatus.OK);
    }

    @ApiOperation(value = "Returns all admins")
    @GetMapping
    public List<AdminInfoDto> getAllAdmins() {
        return adminService.findAll();
    }

    @ApiOperation(value = "Get admin by id")
    @GetMapping("/{id}")
    public AdminInfoDto getAdminById(@PathVariable Long id) {
        return adminService.findById(id);
    }

    @ApiOperation(value = "Returns admins paged")
    @GetMapping(params = {"page", "size"})
    public List<AdminInfoDto> getAdminsPaged(@RequestParam int page, @RequestParam int size){
        return adminService.findPaginated(page, size);
    }
}
