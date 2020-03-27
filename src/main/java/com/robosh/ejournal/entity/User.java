package com.robosh.ejournal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;

    private String secondName;

    private String lastName;

    private String email;

    private String password;

    private String telephone;
    @ManyToOne
    private School school;
}
