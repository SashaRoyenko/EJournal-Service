package com.robosh.ejournal.service;

import com.robosh.ejournal.dto.AdminDto;
import com.robosh.ejournal.entity.admin.Admin;
import com.robosh.ejournal.mapping.AdminMapper;
import com.robosh.ejournal.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    public void save(AdminDto adminDto) {
        if (!adminDto.getPassword().equals(adminDto.getConfirmedPassword())) {
            throw new ValidationException("Password should be same");
        }
        Admin admin = adminMapper.dtoToAdmin(adminDto);
        if (adminDto.getId() == null) {
            admin.setSchool(null);
        }
        adminRepository.save(admin);
    }
}
