package com.robosh.ejournal.data.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "student")
public class Student extends User {

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @OneToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToMany
    @JoinTable(name = "parent_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "parent_id"))
    private List<Parent> parents;

    @Builder
    private Student(
            Long id,
            String firstName,
            String secondName,
            String lastName,
            String email,
            String password,
            String telephone,
            School school,
            LocalDate dateOfBirth,
            Group group,
            List<Parent> parents
    ) {
        super(id, firstName, secondName, lastName, email, password, telephone, school);
        this.dateOfBirth = dateOfBirth;
        this.group = group;
        this.parents = parents;
    }
}
