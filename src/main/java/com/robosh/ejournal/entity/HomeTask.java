package com.robosh.ejournal.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
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

    @Column
    @NotNull
    @OneToOne
    private Subject subject;

    @NotNull
    @OneToOne
    private Group group;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate deadline;
}
