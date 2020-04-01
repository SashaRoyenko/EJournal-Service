package com.robosh.ejournal.data.mapping.admin;

import com.robosh.ejournal.data.dto.admin.AdminInfoDto;
import com.robosh.ejournal.data.entity.admin.Admin;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    AdminInfoDto fromAdminToAdminInfoDto(Admin admin);

    List<AdminInfoDto> fromAdminsToAdminsInfoDto(List<Admin> admins);
}
