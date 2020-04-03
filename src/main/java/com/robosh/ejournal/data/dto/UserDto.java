package com.robosh.ejournal.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    protected Long id;

    @NotBlank
    protected String firstName;

    @NotBlank
    protected String secondName;

    protected String lastName;

    @Pattern(regexp = "[A-Za-z0-9+_.-]+@[a-z.-]+\\.[a-z]{2,8}")
    protected String email;

    @Pattern(regexp = "^\\+?3?8?(0\\d{9})$")
    protected String phone;
}
