package com.turkcell.LibraryApp_ddd.persistence.book;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "books")
public class JpaBookEntity {

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "isbn", nullable = false, length = 20)
    private String isbn;

    @Column(name = "publication_year")
    private Integer publicationYear;

    @Column(name = "category_id", columnDefinition = "uuid")
    private UUID categoryId;

    @Column(name = "author_id", columnDefinition = "uuid")
    private UUID authorId;

    @Column(name = "publisher_id", columnDefinition = "uuid")
    private UUID publisherId;

    // builder-style erişim (senin diğer entity’lerle aynı)
    public UUID id() { return id; }
    public JpaBookEntity setId(UUID id) { this.id = id; return this; }

    public String title() { return title; }
    public JpaBookEntity setTitle(String title) { this.title = title; return this; }

    public String isbn() { return isbn; }
    public JpaBookEntity setIsbn(String isbn) { this.isbn = isbn; return this; }

    public Integer publicationYear() { return publicationYear; }
    public JpaBookEntity setPublicationYear(Integer publicationYear) { this.publicationYear = publicationYear; return this; }

    public UUID categoryId() { return categoryId; }
    public JpaBookEntity setCategoryId(UUID categoryId) { this.categoryId = categoryId; return this; }

    public UUID authorId() { return authorId; }
    public JpaBookEntity setAuthorId(UUID authorId) { this.authorId = authorId; return this; }

    public UUID publisherId() { return publisherId; }
    public JpaBookEntity setPublisherId(UUID publisherId) { this.publisherId = publisherId; return this; }
}
