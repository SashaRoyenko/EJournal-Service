package com.robosh.ejournal.data.dto.group;

import com.robosh.ejournal.data.dto.teacher.TeacherDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupDto {

    protected Long id;

    protected String code;

    protected TeacherDto classTeacher;

}
