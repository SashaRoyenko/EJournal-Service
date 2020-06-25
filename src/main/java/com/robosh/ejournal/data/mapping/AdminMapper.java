package com.robosh.ejournal.data.mapping;

import com.robosh.ejournal.data.dto.admin.AdminInfoDto;
import com.robosh.ejournal.data.dto.admin.SaveAdminDto;
import com.robosh.ejournal.data.entity.School;
import com.robosh.ejournal.data.entity.admin.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = SchoolMapper.class, imports = School.class)
public interface AdminMapper {

    @Mapping(target = "password", ignore = true)
    Admin fromAdminInfoDtoToAdmin(AdminInfoDto adminDto);

    AdminInfoDto fromAdminToAdminInfoDto(Admin admin);

    @Mapping(target = "school",
            expression = "java(saveAdminDto.getSchoolId() == null ? null : " +
                    "School.builder().id(saveAdminDto.getSchoolId()).build())")
    Admin fromSaveAdminDtoToAdmin(SaveAdminDto saveAdminDto);

    List<AdminInfoDto> fromAdminsToAdminsInfoDto(List<Admin> admins);
}
