package com.robosh.ejournal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Group {
    @Id
    @GeneratedValue
    private Long id;
    private String code;

    private List<Student> studentList;

    private Teacher classTeacher;

    private Schedule schedule;
}
