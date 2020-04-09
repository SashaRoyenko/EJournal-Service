package com.robosh.ejournal.data.repository.impl;

import com.robosh.ejournal.data.repository.ValidationRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static com.robosh.ejournal.constant.Query.SELECT_COLUMN_COUNT;

@Repository
public class ValidationRepositoryImpl implements ValidationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean isUnique(String table, String column, String value) {
        int result = entityManager
                .createNativeQuery(SELECT_COLUMN_COUNT.getQuery(table, column, value))
                .getFirstResult();
        return result == 0;
    }
}
