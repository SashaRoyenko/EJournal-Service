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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "class_group")
public class Group {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Pattern(regexp = "\\d{1,2}[-]+[А-ЯЇ]")
    private String code;

    @OneToMany
    private List<Student> studentList;

    @OneToOne
    private Teacher classTeacher;

    @OneToOne
    private Schedule schedule;
}
