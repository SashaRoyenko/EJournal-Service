package com.robosh.ejournal.data.dto.student;

import com.robosh.ejournal.data.dto.UserDto;
import com.robosh.ejournal.data.entity.Parent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveStudentDto extends UserDto {

    private Long groupId;

    private Long schoolId;

    private String password;

    private List<Parent> parents;
}
