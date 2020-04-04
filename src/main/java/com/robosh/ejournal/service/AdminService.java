package com.robosh.ejournal.service;

import com.robosh.ejournal.data.dto.admin.AdminInfoDto;
import com.robosh.ejournal.data.dto.admin.SaveAdminDto;
import com.robosh.ejournal.data.entity.admin.Admin;
import com.robosh.ejournal.data.mapping.AdminMapper;
import com.robosh.ejournal.data.repository.AdminRepository;
import com.robosh.ejournal.util.validation.ValidatorProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminService {

    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    public AdminInfoDto save(SaveAdminDto saveAdminDto) {
        Admin admin = adminMapper.fromUpdateAdminDtoToAdmin(saveAdminDto);

        if (saveAdminDto.getId() == null) {
            admin.setSchool(null);
        }

        ValidatorProcessor.validate(admin);

        adminRepository.save(admin);
        log.info("Admin saved");
        return adminMapper.fromAdminToAdminInfoDto(admin);
    }

    public List<AdminInfoDto> getAllAdmins() {
        return adminMapper.fromAdminsToAdminsInfoDto(adminRepository.findAll());
    }
}
