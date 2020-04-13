package com.robosh.ejournal.data.repository;

import com.robosh.ejournal.data.entity.School;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SchoolRepository extends PagingAndSortingRepository<School, Long> {
    Page<School> findAll(Pageable pageable);
}
