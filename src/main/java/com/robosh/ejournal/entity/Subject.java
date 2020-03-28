package com.robosh.ejournal.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@Entity
public class Subject {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String name;
}
