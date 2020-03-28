package com.robosh.ejournal.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue
    protected Long id;

    protected String firstName;

    protected String secondName;

    protected String lastName;

    protected String email;

    protected String password;

    protected String telephone;

    @ManyToOne
    private School school;
}
