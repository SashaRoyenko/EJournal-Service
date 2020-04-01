package com.robosh.ejournal.data.mapping;

import com.robosh.ejournal.data.dto.school.SchoolWithDirectorDto;
import com.robosh.ejournal.data.entity.School;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchoolMapper {

    SchoolWithDirectorDto fromSchoolToSchoolWithDirectorDTO(School school);
}
