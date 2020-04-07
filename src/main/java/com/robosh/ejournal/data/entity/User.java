package com.robosh.ejournal.data.entity;

import com.robosh.ejournal.util.validation.annotation.PhoneNumberConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @Email
    @Column(name = "email", unique = true)
    protected String email;

    //todo pattern
    @Column(name = "password")
    protected String password;

    @PhoneNumberConstraint
    @Column(name = "phone")
    protected String phone;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "school_id")
    protected School school;
}
