package com.spring.validation.constraints;

public enum REGEX {
    ANY(""),
    NUMBER("[0-9]+"),
    ALPHABET("[a-zA-Z]+"),
    NUMBER_ALPHABET("[a-zA-Z0-9]+"),
    EMAIL("[a-z0-9]+\\@[a-z]+\\.[a-z]+");

    final String regexPattern;

    REGEX(String regexPattern) {
        this.regexPattern = regexPattern;
    }
}
