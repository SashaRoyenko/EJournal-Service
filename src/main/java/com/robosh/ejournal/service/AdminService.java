package com.robosh.ejournal.service;

import com.robosh.ejournal.data.dto.admin.AdminInfoDto;
import com.robosh.ejournal.data.dto.admin.SaveAdminDto;
import com.robosh.ejournal.data.entity.admin.Admin;
import com.robosh.ejournal.data.mapping.AdminMapper;
import com.robosh.ejournal.data.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    public AdminInfoDto save(SaveAdminDto saveAdminDto) {
        if (!saveAdminDto.getPassword().equals(saveAdminDto.getConfirmedPassword())) {
            throw new ValidationException("Password should be same");
        }
        Admin admin = adminMapper.fromUpdateAdminDtoToAdmin(saveAdminDto);
        if (saveAdminDto.getId() == null) {
            admin.setSchool(null);
        }
        adminRepository.save(admin);
        return adminMapper.fromAdminToAdminInfoDto(admin);
    }

    public List<AdminInfoDto> getAllAdmins() {
        return adminMapper.fromAdminsToAdminsInfoDto(adminRepository.findAll());
    }
}
