package com.robosh.ejournal.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    protected Long id;

    protected String firstName;

    protected String secondName;

    protected String lastName;

    protected String email;

    protected String phone;
}
