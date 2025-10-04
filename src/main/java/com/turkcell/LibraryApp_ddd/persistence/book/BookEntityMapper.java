package com.turkcell.LibraryApp_ddd.persistence.book;

import com.turkcell.LibraryApp_ddd.domain.author.model.AuthorId;
import com.turkcell.LibraryApp_ddd.domain.book.model.*;
import com.turkcell.LibraryApp_ddd.domain.category.model.CategoryId;
import com.turkcell.LibraryApp_ddd.domain.publisher.model.PublisherId;
import org.springframework.stereotype.Component;

@Component
public class BookEntityMapper {

    public JpaBookEntity toEntity(Book b) {
        return new JpaBookEntity()
                .setId(b.id().value())
                .setTitle(b.title().value())
                .setIsbn(b.isbn().value())
                .setPublicationYear(b.publicationYear().value())
                .setCategoryId(b.categoryId().value())
                .setAuthorId(b.authorId().value())
                .setPublisherId(b.publisherId().value());
    }

    public Book toDomain(JpaBookEntity e) {
        return Book.rehydrate(
                new BookId(e.id()),
                new BookTitle(e.title()),
                new BookIsbn(e.isbn()),
                new BookPublicationYear(e.publicationYear()),
                new CategoryId(e.categoryId()),
                new AuthorId(e.authorId()),
                new PublisherId(e.publisherId())
        );
    }
}
