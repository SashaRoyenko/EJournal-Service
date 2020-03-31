package com.robosh.ejournal.data.mapping.admin;

import com.robosh.ejournal.data.dto.admin.AdminInfoDTO;
import com.robosh.ejournal.data.entity.admin.Admin;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = {AdminDTOMapper.class}, componentModel = "spring")
public interface AdminMapper {

    AdminInfoDTO fromAdminToAdminInfoDTO(Admin admin);

    List<AdminInfoDTO> fromAdminsToAdminInfoDTOs(List<Admin> admins);
}
