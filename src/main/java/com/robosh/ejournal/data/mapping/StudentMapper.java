package com.robosh.ejournal.data.mapping;

import com.robosh.ejournal.data.dto.student.StudentDto;
import com.robosh.ejournal.data.dto.student.StudentSaveDto;
import com.robosh.ejournal.data.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = Collectors.class)
public interface StudentMapper {

    @Mappings({
            @Mapping(
                    target = "parents",
                    expression = "java(student.getParents().stream()" +
                            ".map(parent->parent.getId())" +
                            ".collect(Collectors.toList()))"
            )
    })
    StudentDto fromStudentToStudentDto(Student student);

    @Mappings({
            @Mapping(source = "groupId", target = "group.id"),
            @Mapping(source = "schoolId", target = "school.id")
    })
    Student fromStudentSaveDtoToStudent(StudentSaveDto dto);
}
