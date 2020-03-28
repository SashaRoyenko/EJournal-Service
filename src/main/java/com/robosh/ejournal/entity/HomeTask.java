package com.robosh.ejournal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class HomeTask {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Subject subject;

    @OneToOne
    private Group group;

    private LocalDate deadline;
}
