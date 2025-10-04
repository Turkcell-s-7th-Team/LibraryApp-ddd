package com.turkcell.LibraryApp_ddd.domain.member.model;

import java.util.Objects;

public record Email(String value) {

    public Email {
        Objects.requireNonNull(value, "Email cannot be null");
        if (value.isBlank()) {
            throw new IllegalArgumentException("Email cannot be blank");
        }
        if (!value.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Invalid email format: " + value);
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
