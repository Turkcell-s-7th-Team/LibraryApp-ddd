package com.turkcell.LibraryApp_ddd.domain.book.model;

import com.turkcell.LibraryApp_ddd.domain.author.model.AuthorId;
import com.turkcell.LibraryApp_ddd.domain.category.model.CategoryId;
import com.turkcell.LibraryApp_ddd.domain.publisher.model.PublisherId;

import java.util.Objects;

public class Book {

    private final BookId id;
    private BookTitle title;
    private BookIsbn isbn;
    private BookPublicationYear publicationYear;

    // İlişki referansları (başka aggregate’lerin Id VO’ları)
    private CategoryId categoryId;
    private AuthorId authorId;
    private PublisherId publisherId;

    private Book(BookId id,
                 BookTitle title,
                 BookIsbn isbn,
                 BookPublicationYear publicationYear,
                 CategoryId categoryId,
                 AuthorId authorId,
                 PublisherId publisherId) {
        this.id = Objects.requireNonNull(id, "Id required");
        this.title = Objects.requireNonNull(title, "Title required");
        this.isbn = Objects.requireNonNull(isbn, "ISBN required");
        this.publicationYear = Objects.requireNonNull(publicationYear, "Publication year required");
        this.categoryId = Objects.requireNonNull(categoryId, "CategoryId required");
        this.authorId = Objects.requireNonNull(authorId, "AuthorId required");
        this.publisherId = Objects.requireNonNull(publisherId, "PublisherId required");
    }

    public static Book create(BookTitle title,
                              BookIsbn isbn,
                              BookPublicationYear publicationYear,
                              CategoryId categoryId,
                              AuthorId authorId,
                              PublisherId publisherId) {
        return new Book(BookId.generateBookId(), title, isbn, publicationYear, categoryId, authorId, publisherId);
    }

    public static Book rehydrate(BookId id,
                                 BookTitle title,
                                 BookIsbn isbn,
                                 BookPublicationYear publicationYear,
                                 CategoryId categoryId,
                                 AuthorId authorId,
                                 PublisherId publisherId) {
        return new Book(id, title, isbn, publicationYear, categoryId, authorId, publisherId);
    }

    // davranışlar
    public void rename(BookTitle newTitle) { this.title = Objects.requireNonNull(newTitle); }
    public void changeIsbn(BookIsbn newIsbn) { this.isbn = Objects.requireNonNull(newIsbn); }
    public void changePublicationYear(BookPublicationYear year) { this.publicationYear = Objects.requireNonNull(year); }

    // getters (DDD tarzı)
    public BookId id() { return id; }
    public BookTitle title() { return title; }
    public BookIsbn isbn() { return isbn; }
    public BookPublicationYear publicationYear() { return publicationYear; }
    public CategoryId categoryId() { return categoryId; }
    public AuthorId authorId() { return authorId; }
    public PublisherId publisherId() { return publisherId; }
}
