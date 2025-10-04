package com.turkcell.LibraryApp_ddd.domain.category.model;

public record CategoryName(String value ) {
    public CategoryName{
        if (value == null || value.isBlank())
            throw new IllegalArgumentException("Category name is required");
        if (value.length() < 3)
            throw new IllegalArgumentException("Category name must be at least 3 characters");
        if (value.length() > 80)
            throw new IllegalArgumentException("Category name must be less than 80 characters");
    }
    @Override
    public String toString() {
        return value;
    }
}
