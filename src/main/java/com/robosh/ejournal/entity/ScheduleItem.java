package com.robosh.ejournal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "schedule_item")
public class ScheduleItem {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @OneToOne
    private Subject subject;

    @ManyToOne
    private Teacher teacher;

    @NotBlank
    @Column(name = "cabinet")
    private String cabinet;

    @NotNull
    @Column(name = "day_of_week")
    private DayOfWeek dayOfWeek;

    @NotNull
    @Column(name = "subject_number")
    private Byte subjectNumber;
}
