package com.robosh.ejournal.data.mapping.school;

import com.robosh.ejournal.data.dto.school.SchoolInfoWithoutDirectorDto;
import com.robosh.ejournal.data.entity.School;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchoolInfoWithoutDirectorDtoMapper {

    School dtoToSchool(SchoolInfoWithoutDirectorDto schoolDto);

    SchoolInfoWithoutDirectorDto schoolToDto(School school);
}
