package com.robosh.ejournal.service;

import com.robosh.ejournal.data.dto.admin.AdminInfoDto;
import com.robosh.ejournal.data.dto.admin.SaveAdminDto;
import com.robosh.ejournal.data.entity.admin.Admin;
import com.robosh.ejournal.data.mapping.AdminMapper;
import com.robosh.ejournal.data.repository.AdminRepository;
import com.robosh.ejournal.exception.ResourceNotFoundException;
import com.robosh.ejournal.util.PasswordGenerator;
import com.robosh.ejournal.util.validation.ValidatorProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminService {

    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;
    private final ModelMapper modelMapper;
    private final PasswordGenerator passwordGenerator;

    public AdminInfoDto save(SaveAdminDto saveAdminDto) {

        Admin admin = adminMapper.fromSaveAdminDtoToAdmin(saveAdminDto);
        admin.setPassword(passwordGenerator.generateRandomPassword());

        saveSchoolForAdmin(saveAdminDto, admin);
        ValidatorProcessor.validate(admin);
        adminRepository.save(admin);
        log.info("Admin saved");
        return adminMapper.fromAdminToAdminInfoDto(admin);
    }

    public AdminInfoDto update(SaveAdminDto updateAdminDto) {

        Admin currentAdmin = findAdminById(updateAdminDto.getId());
        Admin updateAdmin = adminMapper.fromSaveAdminDtoToAdmin(updateAdminDto);

        saveSchoolForAdmin(updateAdminDto, updateAdmin);
        modelMapper.map(updateAdmin, currentAdmin);

        ValidatorProcessor.validate(currentAdmin);
        adminRepository.save(currentAdmin);
        log.info("Admin updated");
        return adminMapper.fromAdminToAdminInfoDto(currentAdmin);
    }

    public List<AdminInfoDto> findAll() {
        return adminMapper.fromAdminsToAdminsInfoDto(adminRepository.findAll());
    }

    public AdminInfoDto findById(Long id) {
        return adminMapper.fromAdminToAdminInfoDto(findAdminById(id));
    }

    public List<AdminInfoDto> findPaginated(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Admin> adminPage = adminRepository.findAll(pageable);

        return adminMapper.fromAdminsToAdminsInfoDto(adminPage.getContent());
    }

    private Admin findAdminById(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin", "id", id));
    }

    private void saveSchoolForAdmin(SaveAdminDto saveAdminDto, Admin admin) {
        if (saveAdminDto.getSchoolId() == null) {
            admin.setSchool(null);
        }
    }
}
