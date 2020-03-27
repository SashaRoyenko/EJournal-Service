package com.robosh.ejournal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.DayOfWeek;

@Entity
public class ScheduleItem {
    @Id
    @GeneratedValue
    private Long id;

    private Subject subject;

    private Teacher teacher;

    private String cabinet;

    private DayOfWeek dayOfWeek;

    private byte subjectNumber;

}
