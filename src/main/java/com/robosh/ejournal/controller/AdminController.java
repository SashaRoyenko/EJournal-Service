package com.robosh.ejournal.controller;

import com.robosh.ejournal.data.dto.admin.AdminInfoDTO;
import com.robosh.ejournal.service.AdminService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AdminController {

    private final AdminService adminService;

    @ApiOperation(value = "Returns all admins")
    @GetMapping("/admins")
    public List<AdminInfoDTO> getAll() {
        return adminService.getAllAdmins();
    }
}
