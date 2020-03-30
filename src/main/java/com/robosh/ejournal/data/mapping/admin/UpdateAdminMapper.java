package com.robosh.ejournal.data.mapping.admin;

import com.robosh.ejournal.data.dto.admin.UpdateAdminDto;
import com.robosh.ejournal.data.entity.admin.Admin;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UpdateAdminMapper {

    @Mapping(source = "schoolId", target = "school.id")
    Admin dtoToAdmin(UpdateAdminDto adminDto);

    @InheritInverseConfiguration
    UpdateAdminDto adminToDto(Admin admin);
}
