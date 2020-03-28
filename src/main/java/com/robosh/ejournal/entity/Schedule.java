package com.robosh.ejournal.entity;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@Builder
@Entity
public class Schedule {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Group group;

    @OneToMany
    private List<ScheduleItem> scheduleList;
}
