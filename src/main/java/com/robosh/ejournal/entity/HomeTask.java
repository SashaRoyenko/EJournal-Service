package com.robosh.ejournal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class HomeTask {
    @Id
    @GeneratedValue
    private Long id;

    private Subject subject;

    private Group group;

    private LocalDate deadline;
}
