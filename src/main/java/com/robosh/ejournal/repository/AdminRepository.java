package com.robosh.ejournal.repository;

import com.robosh.ejournal.entity.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Override
    List<Admin> findAll();
}
