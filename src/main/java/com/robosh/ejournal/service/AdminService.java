package com.robosh.ejournal.service;

import com.robosh.ejournal.data.dto.admin.AdminInfoDTO;
import com.robosh.ejournal.data.mapping.admin.AdminMapper;
import com.robosh.ejournal.data.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final AdminMapper adminMapper;

    private final AdminRepository adminRepository;

    public List<AdminInfoDTO> getAllAdmins() {
        return adminRepository.findAll().stream()
                .map(adminMapper::fromAdminToAdminInfoTDO)
                .collect(Collectors.toList());
    }
}
