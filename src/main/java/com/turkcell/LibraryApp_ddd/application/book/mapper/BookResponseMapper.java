package com.turkcell.LibraryApp_ddd.application.book.mapper;

import com.turkcell.LibraryApp_ddd.application.book.dto.BookResponse;
import com.turkcell.LibraryApp_ddd.domain.book.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookResponseMapper {
    public BookResponse toResponse(Book book) {
        return new BookResponse(
                book.id().value(),
                book.title().value(),
                book.isbn().value(),
                book.publicationYear().value(),
                book.categoryId().value(),
                book.authorId().value(),
                book.publisherId().value()
        );
    }
}
