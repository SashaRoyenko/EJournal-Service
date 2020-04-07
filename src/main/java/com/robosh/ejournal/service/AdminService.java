package com.robosh.ejournal.service;

import com.robosh.ejournal.data.dto.admin.AdminInfoDto;
import com.robosh.ejournal.data.dto.admin.SaveAdminDto;
import com.robosh.ejournal.data.entity.admin.Admin;
import com.robosh.ejournal.data.mapping.AdminMapper;
import com.robosh.ejournal.data.repository.AdminRepository;
import com.robosh.ejournal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;
    private final ModelMapper modelMapper;

    public AdminInfoDto save(SaveAdminDto saveAdminDto) {
        if (!saveAdminDto.getPassword().equals(saveAdminDto.getConfirmedPassword())) {
            throw new ValidationException("Password should be same");
        }
        Admin admin = adminMapper.fromSaveAdminDtoToAdmin(saveAdminDto);
        saveSchoolForAdmin(saveAdminDto, admin);
        adminRepository.save(admin);
        return adminMapper.fromAdminToAdminInfoDto(admin);
    }

    public AdminInfoDto update(SaveAdminDto updateAdminDto) {
        if(updateAdminDto.getPassword() != null) {
            if (!updateAdminDto.getPassword().equals(updateAdminDto.getConfirmedPassword())) {
                throw new ValidationException("Password should be same");
            }
        }

        Admin currentAdmin = findById(updateAdminDto.getId());
        Admin updateAdmin = adminMapper.fromSaveAdminDtoToAdmin(updateAdminDto);

        saveSchoolForAdmin(updateAdminDto, currentAdmin);
        modelMapper.map(updateAdmin, currentAdmin);

        return adminMapper.fromAdminToAdminInfoDto(adminRepository.save(currentAdmin));
    }

    public List<AdminInfoDto> findAll() {
        return adminMapper.fromAdminsToAdminsInfoDto(adminRepository.findAll());
    }

    public Admin findById(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin", "id", id));
    }

    private void saveSchoolForAdmin(SaveAdminDto saveAdminDto, Admin admin) {
        if (saveAdminDto.getSchoolId() == null) {
            admin.setSchool(null);
        }
    }
}
