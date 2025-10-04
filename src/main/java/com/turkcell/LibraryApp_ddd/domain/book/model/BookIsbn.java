package com.turkcell.LibraryApp_ddd.domain.book.model;

public record BookIsbn(String value) {
    public BookIsbn {
        if (value == null || value.isBlank())
            throw new IllegalArgumentException("ISBN is required");

        String digits = value.replaceAll("[^0-9Xx]", "");
        if (!(digits.length() == 10 || digits.length() == 13))
            throw new IllegalArgumentException("ISBN must be 10 or 13 digits");
    }
    @Override public String toString() { return value; }
}
