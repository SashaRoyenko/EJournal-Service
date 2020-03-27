package com.robosh.ejournal.entity;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Student extends User {
    private LocalDate dateOfBirth;

    private Group group;

    private Parent parent;

}
