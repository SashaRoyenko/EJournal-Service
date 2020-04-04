package com.robosh.ejournal.data.dto.admin;

import com.robosh.ejournal.data.entity.admin.AdminRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveAdminDto {

    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Pattern(regexp = "[A-Za-z0-9+_.-]+@[a-z.-]+\\.[a-z]{2,8}")
    private String email;

    private String password;

    private String confirmedPassword;

    private Long schoolId;

    private AdminRole adminRole;
}
