package com.robosh.ejournal.data.dto.teacher;

import com.robosh.ejournal.data.dto.UserDto;
import com.robosh.ejournal.util.validation.annotation.FieldsValueMatch;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@FieldsValueMatch(
        field = "password",
        fieldMatch = "confirmedPassword",
        message = "Паролі мають бути однаковими"
)
public class SaveTeacherDto extends UserDto {

    private String description;

    private Long groupId;

    private String password;

    private String confirmedPassword;

    private Long schoolId;

    @Builder
    private SaveTeacherDto(
            Long id,
            String firstName,
            String secondName,
            String lastName,
            String email,
            String phone,
            String description,
            Long groupId,
            String password,
            String confirmedPassword,
            Long schoolId
    ) {
        super(id, firstName, secondName, lastName, email, phone);
        this.description = description;
        this.groupId = groupId;
        this.password = password;
        this.confirmedPassword = confirmedPassword;
        this.schoolId = schoolId;
    }
}
