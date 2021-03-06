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

    private String description;

    private Long groupId;

    private Long schoolId;

    @Builder
    private TeacherDto(
            Long id,
            String firstName,
            String secondName,
            String lastName,
            String email,
            String phone,
            String description,
            Long groupId,
            Long schoolId
    ) {
        super(id, firstName, secondName, lastName, email, phone);
        this.description = description;
        this.groupId = groupId;
        this.schoolId = schoolId;
    }
}
