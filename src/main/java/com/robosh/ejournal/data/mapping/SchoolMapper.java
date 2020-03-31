package com.robosh.ejournal.data.mapping;

import com.robosh.ejournal.data.dto.school.SchoolWithDirectorDTO;
import com.robosh.ejournal.data.entity.School;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchoolMapper {

    SchoolWithDirectorDTO fromSchoolToSchoolWithDirectorDTO(School school);
}
