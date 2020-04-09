package com.robosh.ejournal.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Query {

    SELECT_COLUMN_COUNT("SELECT count(*) from %s where '%s' = '%s'");

    private String query;

    public String getQuery(Object... values) {
        return String.format(query, values);
    }
}
