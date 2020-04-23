package com.robosh.ejournal.data.dto.student;

import com.robosh.ejournal.data.dto.UserDto;
import com.robosh.ejournal.util.validation.annotation.FieldsValueMatch;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldsValueMatch(
        field = "password",
        fieldMatch = "confirmedPassword",
        message = "Паролі мають бути однаковими"
)
public class SaveStudentDto extends UserDto {

    private Long groupId;

    private Long schoolId;

    private String password;

    private String confirmedPassword;

    private List<Long> parents;

    @Builder
    private SaveStudentDto(
            Long id,
            String firstName,
            String secondName,
            String lastName,
            String email,
            String phone,
            Long groupId,
            Long schoolId,
            String password,
            List<Long> parents,
            String confirmedPassword
    ) {
        super(id, firstName, secondName, lastName, email, phone);
        this.groupId = groupId;
        this.schoolId = schoolId;
        this.password = password;
        this.parents = parents;
        this.confirmedPassword = confirmedPassword;
    }
}
