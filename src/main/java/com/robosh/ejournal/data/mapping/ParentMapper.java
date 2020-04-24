package com.robosh.ejournal.data.mapping;

import com.robosh.ejournal.data.dto.parent.ParentDto;
import com.robosh.ejournal.data.dto.parent.SaveParentDto;
import com.robosh.ejournal.data.dto.parent.UpdateParentDto;
import com.robosh.ejournal.data.entity.Parent;
import com.robosh.ejournal.data.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = {Collectors.class, Student.class})
public interface ParentMapper {
    @Mappings({
            @Mapping(source = "schoolId", target = "school.id"),
            @Mapping(
                    target = "studentList",
                    expression = "java(dto.getStudentList().stream()" +
                            ".map((id)-> Student.builder()" +
                            ".id(id)" +
                            ".build())" +
                            ".collect(Collectors.toList()))"
            )
    })
    Parent fromSaveParentDtoToParent(SaveParentDto dto);

    @Mappings({
            @Mapping(
                    target = "studentList",
                    expression = "java(parent.getStudentList().stream()" +
                            ".map(student->student.getId())" +
                            ".collect(Collectors.toList()))"
            )
    })
    ParentDto fromParentToParentDto(Parent parent);

    @Mappings({
            @Mapping(source = "schoolId", target = "school.id"),
            @Mapping(
                    target = "studentList",
                    expression = "java(dto.getStudentList().stream()" +
                            ".map((id)-> Student.builder()" +
                            ".id(id)" +
                            ".build())" +
                            ".collect(Collectors.toList()))"
            )
    })
    Parent fromUpdateParentDtoToParent(UpdateParentDto dto);
}
