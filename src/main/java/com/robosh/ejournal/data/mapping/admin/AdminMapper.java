package com.robosh.ejournal.data.mapping.admin;

import com.robosh.ejournal.data.dto.admin.AdminInfoDto;
import com.robosh.ejournal.data.dto.admin.UpdateAdminDto;
import com.robosh.ejournal.data.entity.admin.Admin;
import com.robosh.ejournal.data.mapping.school.SchoolMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = SchoolMapper.class)
public interface AdminMapper {

    Admin fromAdminInfoDtoToAdmin(AdminInfoDto adminDto);

    AdminInfoDto fromAdminToAdminInfoDto(Admin admin);

    @Mapping(source = "schoolId", target = "school.id")
    Admin fromUpdateAdminDtoToAdmin(UpdateAdminDto adminDto);

    @InheritInverseConfiguration
    UpdateAdminDto fromAdminToUpdateAdminDto(Admin admin);
}
