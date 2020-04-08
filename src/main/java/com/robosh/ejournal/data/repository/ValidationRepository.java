package com.robosh.ejournal.data.repository;

import com.robosh.ejournal.data.entity.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ValidationRepository extends JpaRepository<Admin, Long> {

    @Query(value = "Select count(?1) from ?2 where ?1 = ?3", nativeQuery = true)
    boolean checkUnique(String column, String table, String value);
}