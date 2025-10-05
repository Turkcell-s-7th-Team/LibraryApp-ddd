package com.turkcell.LibraryApp_ddd.domain.book.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public record BookId(UUID value) implements Serializable {
    public BookId{
        Objects.requireNonNull(value, "BookId value cannot be null");
    }
    public static BookId generateBookId() { return new BookId(UUID.randomUUID());
    }


}
