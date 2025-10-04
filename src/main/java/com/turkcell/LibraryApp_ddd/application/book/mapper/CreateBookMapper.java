package com.turkcell.LibraryApp_ddd.application.book.mapper;

import com.turkcell.LibraryApp_ddd.application.book.command.CreateBookCommand;
import com.turkcell.LibraryApp_ddd.domain.author.model.AuthorId;
import com.turkcell.LibraryApp_ddd.domain.book.model.*;
import com.turkcell.LibraryApp_ddd.domain.category.model.CategoryId;
import com.turkcell.LibraryApp_ddd.domain.publisher.model.PublisherId;
import org.springframework.stereotype.Component;

@Component
public class CreateBookMapper {

    public Book toDomain(CreateBookCommand command) {
        return Book.create(
                new BookTitle(command.title()),
                new BookIsbn(command.isbn()),
                new BookPublicationYear(command.publicationYear()),
                new CategoryId(command.categoryId()),
                new AuthorId(command.authorId()),
                new PublisherId(command.publisherId())
        );
    }
}
