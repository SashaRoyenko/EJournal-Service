package com.robosh.ejournal.data.repository;

import com.robosh.ejournal.data.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
        Page<Student> findAllBySchoolId(Long id, Pageable pageable);
}
