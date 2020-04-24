package com.robosh.ejournal.data.repository;

import com.robosh.ejournal.data.entity.Parent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, Long> {
    Page<Parent> findAllBySchoolId(Long id, Pageable pageable);
}
