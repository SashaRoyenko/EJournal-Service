package com.robosh.ejournal.data.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface ValidationRepository {

    boolean isUnique(String table, String column, String value);
}