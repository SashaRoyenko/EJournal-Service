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
public class SaveParentDto extends UserDto {

    private List<Long> studentList;

    private String password;

    private String confirmedPassword;

    private Long schoolId;

    @Builder
    private SaveParentDto(
            Long id,
            String firstName,
            String secondName,
            String lastName,
            String email,
            String phone,
            List<Long> studentList,
            String password,
            String confirmedPassword,
            Long schoolId) {
        super(id, firstName, secondName, lastName, email, phone);
        this.studentList = studentList;
        this.password = password;
        this.confirmedPassword = confirmedPassword;
        this.schoolId = schoolId;
    }
}
