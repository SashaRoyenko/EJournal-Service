package com.robosh.ejournal.data.mapping;

import com.robosh.ejournal.data.dto.admin.AdminInfoDto;
import com.robosh.ejournal.data.dto.admin.UpdateAdminDto;
import com.robosh.ejournal.data.entity.admin.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = SchoolMapper.class)
public interface AdminMapper {

    @Mapping(target = "password", ignore = true)
    Admin fromAdminInfoDtoToAdmin(AdminInfoDto adminDto);

    AdminInfoDto fromAdminToAdminInfoDto(Admin admin);

    @Mappings({
            @Mapping(source = "schoolId", target = "school.id")
    })
    Admin fromUpdateAdminDtoToAdmin(UpdateAdminDto adminDto);

    List<AdminInfoDto> fromAdminsToAdminsInfoDto(List<Admin> admins);
}
