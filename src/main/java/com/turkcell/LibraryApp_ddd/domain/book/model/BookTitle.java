package com.turkcell.LibraryApp_ddd.domain.book.model;

public record BookTitle(String value) {
    public BookTitle{
        if (value == null || value.isBlank()) throw new IllegalArgumentException("Title is required");
        if (value.length() < 2)
            throw new IllegalArgumentException("Title must be at least 2 chars");
        if (value.length() > 200)
            throw new IllegalArgumentException("Title must be ≤ 200 chars");
    }
    @Override public String toString() { return value; }
}
