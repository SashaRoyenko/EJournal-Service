package com.robosh.ejournal.data.mapping;

import com.robosh.ejournal.data.dto.teacher.SaveTeacherDto;
import com.robosh.ejournal.data.dto.teacher.TeacherDto;
import com.robosh.ejournal.data.entity.Group;
import com.robosh.ejournal.data.entity.School;
import com.robosh.ejournal.data.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", imports = {Group.class, School.class})
public interface TeacherMapper {
    @Mappings({
            @Mapping(source = "group.id", target = "groupId"),
            @Mapping(source = "school.id", target = "schoolId")})
    TeacherDto fromTeacherToTeacherDto(Teacher teacher);

    @Mappings({
            @Mapping(target = "group",
                    expression = "java(saveTeacherDto.getGroupId() == null ? null : " +
                            "Group.builder().id(saveTeacherDto.getGroupId()).build())"),
            @Mapping(target = "school",
                    expression = "java(saveTeacherDto.getSchoolId() == null ? null : " +
                            "School.builder().id(saveTeacherDto.getSchoolId()).build())")
    })
    Teacher fromSaveTeacherDtoToTeacher(SaveTeacherDto saveTeacherDto);

    List<TeacherDto> fromTeachersToTeachersDto(List<Teacher> teachers);
}
