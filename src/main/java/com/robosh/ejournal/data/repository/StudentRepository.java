package com.robosh.ejournal.data.repository;

import com.robosh.ejournal.data.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
