package com.robosh.ejournal.mapper;

import com.robosh.ejournal.dto.SchoolWithDirectorDTO;
import com.robosh.ejournal.entity.School;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SchoolMapper {

    SchoolMapper SCHOOL_MAPPER = Mappers.getMapper(SchoolMapper.class);

    SchoolWithDirectorDTO fromSchoolToSchoolWithDirectorDTO(School school);
}
