package com.robosh.ejournal.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
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
