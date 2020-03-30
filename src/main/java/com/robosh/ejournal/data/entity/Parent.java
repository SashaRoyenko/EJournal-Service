package com.robosh.ejournal.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "parent")
public class Parent extends User {

    @ManyToMany
    @JoinTable(name = "parent_student",
            joinColumns = @JoinColumn(name = "parent_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> studentList;

    @Builder
    private Parent(Long id, String firstName, String secondName, String lastName, String email, String password, String telephone, School school, List<Student> studentList) {
        super(id, firstName, secondName, lastName, email, password, telephone, school);
        this.studentList = studentList;
    }
}
