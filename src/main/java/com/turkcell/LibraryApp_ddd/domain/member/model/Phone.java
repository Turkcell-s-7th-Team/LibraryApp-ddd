package com.turkcell.LibraryApp_ddd.domain.member.model;

import java.util.Objects;

public record Phone(String value) {
    public Phone {
        Objects.requireNonNull(value, "Phone cannot be null");
        if (value.isBlank()) {
            throw new IllegalArgumentException("Phone cannot be blank");
        }
        if (!value.matches("^[0-9]{10,15}$")) {
            throw new IllegalArgumentException("Invalid phone number format: " + value);
        }
    }
    @Override
    public String toString() {
        return value;
    }
}