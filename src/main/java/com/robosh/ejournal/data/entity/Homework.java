package com.robosh.ejournal.data.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "homework")
public class Homework {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @NotNull
    @OneToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "deadline")
    private LocalDate deadline;
}
