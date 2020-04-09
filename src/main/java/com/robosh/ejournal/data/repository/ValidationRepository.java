package com.robosh.ejournal.data.repository;

public interface ValidationRepository {

    boolean isUnique(String table, String column, String value);
}
