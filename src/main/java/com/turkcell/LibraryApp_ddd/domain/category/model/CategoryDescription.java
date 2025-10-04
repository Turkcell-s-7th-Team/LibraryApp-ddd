package com.turkcell.LibraryApp_ddd.domain.category.model;

public record CategoryDescription(String value)  {
    public CategoryDescription {
        if (value == null || value.isBlank())
            throw new IllegalArgumentException("Description is required");
        if (value.length()< 3 )
            throw new IllegalArgumentException("Description must be at least 3 characters");
        if (value.length() > 255)
            throw new IllegalArgumentException("Description must be less than 255 characters");
    }
    @Override
    public String toString() {
        return value;
    }
}
