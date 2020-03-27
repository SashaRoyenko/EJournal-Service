package com.robosh.ejournal.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Builder
@Entity
public class Mark {
    @Id
    @GeneratedValue
    private Long id;

    private String score;
    @OneToOne
    private Student student;
    @OneToOne
    private Teacher teacher;
    @OneToOne
    private Subject subject;

    private LocalDate date;
}
