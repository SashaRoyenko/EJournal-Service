package com.robosh.ejournal.data.dto.parent;

import com.robosh.ejournal.data.dto.UserDto;
import com.robosh.ejournal.util.validation.annotation.FieldsValueMatch;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@Data
@FieldsValueMatch(
        field = "password",
        fieldMatch = "confirmedPassword",
        message = "Паролі мають бути однаковими"
)
public class UpdateParentDto extends UserDto {

    private String password;

    private String confirmedPassword;

    private List<Long> studentList;

    private Long schoolId;

    @Builder
    private UpdateParentDto(
            Long id,
            String firstName,
            String secondName,
            String lastName,
            String email,
            String phone,
            String password,
            String confirmedPassword,
            List<Long> studentList,
            Long schoolId) {
        super(id, firstName, secondName, lastName, email, phone);
        this.password = password;
        this.confirmedPassword = confirmedPassword;
        this.studentList = studentList;
        this.schoolId = schoolId;
    }
}
