package com.robosh.ejournal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Entity
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
    private String cabinet;

    @NotNull
    private DayOfWeek dayOfWeek;

    @NotNull
    private Byte subjectNumber;
}
