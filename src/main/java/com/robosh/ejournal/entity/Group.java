package com.robosh.ejournal.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@NoArgsConstructor
@Builder
@Entity(name = "class_group")
public class Group {
    @Id
    @GeneratedValue
    private Long id;

    private String code;

    @OneToMany
    private List<Student> studentList;

    @OneToOne
    private Teacher classTeacher;

    @OneToOne
    private Schedule schedule;
}
