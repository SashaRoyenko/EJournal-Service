package com.robosh.ejournal.data.mapping.admin;

import com.robosh.ejournal.data.dto.admin.AdminInfoDto;
import com.robosh.ejournal.data.entity.admin.Admin;
import com.robosh.ejournal.data.mapping.school.SchoolInfoWithoutDirectorDtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = SchoolInfoWithoutDirectorDtoMapper.class)
public interface AdminDtoInfoMapper {

    Admin dtoToAdmin(AdminInfoDto adminDto);

    AdminInfoDto adminToDto(Admin admin);
}
