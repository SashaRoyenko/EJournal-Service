package com.robosh.ejournal.data.mapping;

import com.robosh.ejournal.data.dto.teacher.SaveTeacherDto;
import com.robosh.ejournal.data.dto.teacher.TeacherDto;
import com.robosh.ejournal.data.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    @Mappings({
            @Mapping(source = "group.id", target = "groupId"),
            @Mapping(source = "school.id", target = "schoolId")})
    TeacherDto fromTeacherToTeacherDto(Teacher teacher);

    @Mappings({
            @Mapping(target = "group.id", source = "groupId"),
            @Mapping(target = "school.id", source = "schoolId")})
    Teacher fromSaveTeacherDtoToTeacher(SaveTeacherDto dto);
}
