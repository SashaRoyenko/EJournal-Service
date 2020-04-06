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

    protected String email;

    protected String phone;
}
