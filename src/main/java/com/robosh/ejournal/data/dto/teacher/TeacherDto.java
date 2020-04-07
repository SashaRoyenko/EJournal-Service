package com.robosh.ejournal.data.dto.teacher;

import com.robosh.ejournal.data.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDto extends UserDto {

    protected String description;

    @Builder
    private TeacherDto(Long id, String firstName, String secondName, String lastName, String email, String phone, String description) {
        super(id, firstName, secondName, lastName, email, phone);
        this.description = description;
    }
}
