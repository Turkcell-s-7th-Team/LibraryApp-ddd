package com.turkcell.LibraryApp_ddd.domain.member.model;

import java.util.Objects;

public record Address(String value) {

    public Address {
        Objects.requireNonNull(value, "Address cannot be null");
        if (value.isBlank()) {
            throw new IllegalArgumentException("Address cannot be blank");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("Address is too long");
        }
    }
}