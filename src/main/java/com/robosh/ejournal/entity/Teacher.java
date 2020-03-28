package com.robosh.ejournal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Teacher extends User {

    @OneToOne
    private Group group;

    private String description;

    @Builder
    private Teacher(Long id, String firstName, String secondName, String lastName, String email, String password, String telephone, School school, Group group, String description) {
        super(id, firstName, secondName, lastName, email, password, telephone, school);
        this.group = group;
        this.description = description;
    }
}
