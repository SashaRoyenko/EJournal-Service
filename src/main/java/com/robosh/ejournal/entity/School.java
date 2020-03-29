package com.robosh.ejournal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "school")
public class School {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @NotBlank
    @Column(name = "department")
    private String department;

    @NotBlank
    @Column(name = "region")
    private String region;

    @NotBlank
    @Column(name = "locality")
    private String locality;

    @OneToOne
    private Director director;
}
