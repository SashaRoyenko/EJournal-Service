package com.robosh.ejournal.data.dto.admin;

import com.robosh.ejournal.data.entity.admin.AdminRole;
import com.robosh.ejournal.util.validation.annotation.FieldsValueMatch;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldsValueMatch(
        field = "password",
        fieldMatch = "confirmedPassword",
        message = "Паролі мають бути однаковими"
)
public class SaveAdminDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String confirmedPassword;

    private Long schoolId;

    private AdminRole adminRole;
}
