package com.robosh.ejournal.dto;

import com.robosh.ejournal.entity.School;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    protected Long id;

    protected String firstName;

    protected String secondName;

    protected String lastName;

    protected String email;

    protected String phone;

    protected School school;
}
