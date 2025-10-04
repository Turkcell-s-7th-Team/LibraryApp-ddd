package com.turkcell.LibraryApp_ddd.application.book.dto;

import java.util.UUID;

public record BookResponse(
        UUID id,
        String title,
        String isbn,
        Integer publicationYear,
        UUID categoryId,
        UUID authorId,
        UUID publisherId
) { }
