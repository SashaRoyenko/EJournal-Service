package com.robosh.ejournal.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Student extends User {

    private LocalDate dateOfBirth;

    private Group group;

    private List<Parent> parents;

}
