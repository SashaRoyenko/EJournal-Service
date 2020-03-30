package com.robosh.ejournal.mapper;

import com.robosh.ejournal.dto.AdminDTO;
import com.robosh.ejournal.entity.admin.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    AdminMapper ADMIN_MAPPER = Mappers.getMapper(AdminMapper.class);

    AdminDTO fromAdminToAdminTDO(Admin admin);
}
