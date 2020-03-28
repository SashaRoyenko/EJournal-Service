package com.robosh.ejournal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    protected Long id;

    @NotBlank
    protected String firstName;

    protected String secondName;

    @NotBlank
    protected String lastName;

    @Pattern(regexp = "[A-Za-z0-9+_.-]+@[a-z.-]+\\.[a-z]{2,8}")
    protected String email;

    //todo pattern
    protected String password;

    @Pattern(regexp = "^\\+?3?8?(0\\d{9})$")
    protected String phone;

    @NotNull
    @ManyToOne
    protected School school;
}
