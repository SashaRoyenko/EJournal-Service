package com.robosh.ejournal.data.mapping;

import com.robosh.ejournal.data.dto.student.SaveStudentDto;
import com.robosh.ejournal.data.dto.student.StudentDto;
import com.robosh.ejournal.data.entity.Parent;
import com.robosh.ejournal.data.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = {Collectors.class, Parent.class})
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
            @Mapping(source = "schoolId", target = "school.id"),
            @Mapping(
                    target = "parents",
                    expression = "java(dto.getParents().stream()" +
                            ".map((id)-> Parent.builder()" +
                            ".id(id)" +
                            ".build())" +
                            ".collect(Collectors.toList()))"
            )
    })
    Student fromStudentSaveDtoToStudent(SaveStudentDto dto);

    List<StudentDto> fromStudentsToStudentsDto(List<Student> students);
}
