package com.robosh.ejournal.repository;

import com.robosh.ejournal.entity.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
