package com.robosh.ejournal.data.repository;

import com.robosh.ejournal.data.entity.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
