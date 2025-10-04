package com.turkcell.LibraryApp_ddd.domain.book.model;

import java.time.Year;

public record BookPublicationYear(Integer value) {
    public BookPublicationYear {
        if (value == null) throw new IllegalArgumentException("Publication year required");
        int now = Year.now().getValue();
        if (value < 1400 || value > now + 1)
            throw new IllegalArgumentException("Publication year is not valid");
    }
    @Override public String toString() { return String.valueOf(value); }
}
