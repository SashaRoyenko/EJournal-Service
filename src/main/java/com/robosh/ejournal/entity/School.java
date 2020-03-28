package com.robosh.ejournal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class School {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String name;

    private String url;

    @NotBlank
    private String department;

    @NotBlank
    private String region;

    @NotBlank
    private String locality;

    @OneToOne
    private Director director;
}
