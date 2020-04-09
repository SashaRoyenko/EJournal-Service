package com.robosh.ejournal.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Query {

    CHECK_EMAIL_UNIQUE("SELECT count(*) from %s where '%s' = '%s'");

    private String query;

    public String getQuery(Object... values) {
        return String.format(query, values);
    }
}
