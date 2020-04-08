package com.robosh.ejournal.constant.regex;

import lombok.Getter;

@Getter
public enum Regex {
    PHONE_NUMBER("^\\+?3?8?(0\\d{9})$");

    Regex(String regex) {
        this.regex = regex;
    }

    private String regex;
}
