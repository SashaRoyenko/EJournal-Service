package com.robosh.ejournal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student extends User {

    private LocalDate dateOfBirth;

    @OneToOne
    private Group group;

    @ManyToMany
    private List<Parent> parents;

    @Builder
    private Student(Long id, String firstName, String secondName, String lastName, String email, String password, String telephone, School school, LocalDate dateOfBirth, Group group, List<Parent> parents) {
        super(id, firstName, secondName, lastName, email, password, telephone, school);
        this.dateOfBirth = dateOfBirth;
        this.group = group;
        this.parents = parents;
    }
}
