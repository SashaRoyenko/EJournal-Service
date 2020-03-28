package com.robosh.ejournal.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import java.time.DayOfWeek;

@Data
@NoArgsConstructor
@Builder
@Entity
public class ScheduleItem {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Subject subject;

    @ManyToOne
    private Teacher teacher;

    private String cabinet;

    private DayOfWeek dayOfWeek;

    private byte subjectNumber;
}