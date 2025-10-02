package com.turkcell.LibraryApp_ddd.domain.author.model;

import java.io.Serializable;

public record AuthorFullName(String name, String surname){
    public AuthorFullName {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name required");
        if (surname == null || surname.isBlank()) throw new IllegalArgumentException("Surname required");
        if (name.length() > 80 || surname.length() > 80) throw new IllegalArgumentException("Name too long");
    }
    public String fullName() { return name + " " + surname; }
}
