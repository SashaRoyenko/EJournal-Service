package com.robosh.ejournal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue
    protected Long id;

    @NotBlank
    @Column(name = "first_name")
    protected String firstName;

    @Column(name = "second_name")
    protected String secondName;

    @NotBlank
    @Column(name = "last_name")
    protected String lastName;

    @Pattern(regexp = "[A-Za-z0-9+_.-]+@[a-z.-]+\\.[a-z]{2,8}")
    @Column(name = "email")
    protected String email;

    //todo pattern
    @Column(name = "password")
    protected String password;

    @Pattern(regexp = "^\\+?3?8?(0\\d{9})$")
    @Column(name = "phone")
    protected String phone;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "school_id")
    protected School school;
}
