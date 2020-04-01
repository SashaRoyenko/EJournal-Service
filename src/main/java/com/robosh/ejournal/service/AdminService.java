package com.robosh.ejournal.service;

import com.robosh.ejournal.data.dto.admin.AdminInfoDto;
import com.robosh.ejournal.data.mapping.admin.AdminMapper;
import com.robosh.ejournal.data.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final AdminMapper adminMapper;
    private final AdminRepository adminRepository;

    public List<AdminInfoDto> getAllAdmins() {
        return adminMapper.fromAdminsToAdminsInfoDto(adminRepository.findAll());
    }
}
