package com.robosh.ejournal.data.repository;

import com.robosh.ejournal.data.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Page<Teacher> findAllBySchoolId(Long id, Pageable pageable);
}
