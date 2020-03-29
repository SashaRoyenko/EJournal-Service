package com.robosh.ejournal.repository;

import com.robosh.ejournal.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
