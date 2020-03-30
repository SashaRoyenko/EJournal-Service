package com.robosh.ejournal.service;

import com.robosh.ejournal.dto.AdminDTO;
import com.robosh.ejournal.mapper.AdminMapper;
import com.robosh.ejournal.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final AdminMapper adminMapper;

    private final AdminRepository adminRepository;

    public List<AdminDTO> getAllAdmins() {
        return adminRepository.findAll().stream()
                .map(adminMapper.ADMIN_MAPPER::fromAdminToAdminTDO)
                .collect(Collectors.toList());
    }
}
