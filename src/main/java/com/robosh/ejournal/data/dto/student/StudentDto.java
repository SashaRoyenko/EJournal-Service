package com.robosh.ejournal.data.dto.student;

import com.robosh.ejournal.data.dto.UserDto;
import com.robosh.ejournal.data.dto.group.GroupDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
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

    @Builder
    private StudentDto(
            Long id,
            String firstName,
            String secondName,
            String lastName,
            String email,
            String phone,
            LocalDate dateOfBirth,
            List<Long> parents,
            GroupDto group
    ) {
        super(id, firstName, secondName, lastName, email, phone);
        this.dateOfBirth = dateOfBirth;
        this.parents = parents;
        this.group = group;
    }
}
