package com.robosh.ejournal.data.mapping;

import com.robosh.ejournal.data.dto.school.SaveSchoolDto;
import com.robosh.ejournal.data.dto.school.SchoolInfoDto;
import com.robosh.ejournal.data.entity.School;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchoolMapper {

    School fromSchoolInfoDtoToSchool(SchoolInfoDto schoolDto);

    SchoolInfoDto fromSchoolToSchoolInfoDto(School school);

    School fromSaveSchoolDtoToSchool(SaveSchoolDto dto);
}
