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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "mark")
public class Mark {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(name = "score")
    private String score;

    @NotNull
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @NotNull
    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @NotNull
    @OneToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date")
    private LocalDate date;
}
