package com.turkcell.LibraryApp_ddd.application.book.command;

import com.turkcell.LibraryApp_ddd.application.book.dto.CreatedBookResponse;
import com.turkcell.LibraryApp_ddd.core.cqrs.Command;

import java.util.UUID;

public record CreateBookCommand(
        String title,
        String isbn,
        Integer publicationYear,
        UUID categoryId,
        UUID authorId,
        UUID publisherId
) implements Command<CreatedBookResponse> {}