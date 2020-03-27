package com.robosh.ejournal.entity;

import javax.persistence.Entity;

@Entity
public class Teacher extends User {
    private Subject profileSubject;

    private Group group;

    private String description;
}
