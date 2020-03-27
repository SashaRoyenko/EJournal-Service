package com.robosh.ejournal.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Parent extends User{
    @ManyToMany
    private List<Student> studentList;

    @Builder
    private Parent(Long id, String firstName, String secondName, String lastName, String email, String password, String telephone, School school, List<Student> studentList) {
        super(id, firstName, secondName, lastName, email, password, telephone, school);
        this.studentList = studentList;
    }
}
