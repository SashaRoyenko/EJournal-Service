package com.robosh.ejournal.data.mapping;

import com.robosh.ejournal.data.dto.school.SchoolInfoDto;
import com.robosh.ejournal.data.dto.school.SchoolWithDirectorInfoDto;
import com.robosh.ejournal.data.entity.School;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchoolMapper {

    School dtoToSchool(SchoolInfoDto schoolDto);

    SchoolInfoDto schoolToDto(School school);
}
