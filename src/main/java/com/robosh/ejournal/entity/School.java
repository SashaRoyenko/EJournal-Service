package com.robosh.ejournal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class School {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String url;

    private String departament;

    private String region;

    private String locality;

    private Director director;
}
