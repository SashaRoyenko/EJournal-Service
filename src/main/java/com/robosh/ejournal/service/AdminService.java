package com.robosh.ejournal.service;

import com.robosh.ejournal.data.dto.admin.AdminInfoDto;
import com.robosh.ejournal.data.dto.admin.UpdateAdminDto;
import com.robosh.ejournal.data.entity.admin.Admin;
import com.robosh.ejournal.data.mapping.admin.AdminDtoInfoMapper;
import com.robosh.ejournal.data.mapping.admin.UpdateAdminMapper;
import com.robosh.ejournal.data.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    private final UpdateAdminMapper updateAdminMapper;
    private final AdminDtoInfoMapper adminDtoInfoMapper;

    public AdminInfoDto save(UpdateAdminDto updateAdminDto) {
        if (!updateAdminDto.getPassword().equals(updateAdminDto.getConfirmedPassword())) {
            throw new ValidationException("Password should be same");
        }
        Admin admin = updateAdminMapper.dtoToAdmin(updateAdminDto);
        if (updateAdminDto.getId() == null) {
            admin.setSchool(null);
        }
        adminRepository.save(admin);
        return adminDtoInfoMapper.adminToDto(admin);
    }
}
