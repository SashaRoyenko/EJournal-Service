package com.robosh.ejournal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
@Entity
public class Mark {
    @Id
    @GeneratedValue
    private Long id;
    private int score;

    private Student student;

    private Teacher teacher;

    private Subject subject;

    private LocalDate date;
}
