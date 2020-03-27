package com.robosh.ejournal.entity;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Parent extends User{
    private List<Student> studentList;
}
