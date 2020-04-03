package com.robosh.ejournal.data.dto.student;

import com.robosh.ejournal.data.dto.UserDto;
import com.robosh.ejournal.data.dto.group.GroupDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto extends UserDto {

    private LocalDate dateOfBirth;

    private List<Long> parents;

    private GroupDto group;
}
