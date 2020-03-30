package com.robosh.ejournal.controller;

import com.robosh.ejournal.dto.AdminDTO;
import com.robosh.ejournal.service.AdminService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AdminController {

    private final AdminService adminService;

    @ApiOperation(value = "returns all admins")
    @RequestMapping(path = "/admins", method = RequestMethod.GET)
    public List<AdminDTO> getAll() {
        return adminService.getAllAdmins();
    }
}
