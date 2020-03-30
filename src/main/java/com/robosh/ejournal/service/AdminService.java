package com.robosh.ejournal.service;

import com.robosh.ejournal.dto.AdminDTO;
import com.robosh.ejournal.mapper.AdminMapper;
import com.robosh.ejournal.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<AdminDTO> getAllAdmins() {
        return adminRepository.findAll().stream()
                .map(AdminMapper.ADMIN_MAPPER::fromAdminToAdminTDO)
                .collect(Collectors.toList());
    }
}
