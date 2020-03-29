package com.robosh.ejournal.mapping;

import com.robosh.ejournal.dto.AdminDto;
import com.robosh.ejournal.entity.admin.Admin;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    @Mappings({
            @Mapping(source = "schoolId", target = "school.id")
    })
    Admin dtoToAdmin(AdminDto adminDto);

    @InheritInverseConfiguration
    AdminDto adminToDto(Admin admin);
}
