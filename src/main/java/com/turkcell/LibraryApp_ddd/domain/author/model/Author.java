package com.turkcell.LibraryApp_ddd.domain.author.model;

import java.util.Objects;

public class Author {

    private final AuthorId id;
    private AuthorFullName authorFullName;
    private AuthorEmail authorEmail;
    private AuthorPhoneNumber authorPhoneNumber;

    private Author(AuthorId id, AuthorFullName authorFullName, AuthorEmail authorEmail, AuthorPhoneNumber authorPhoneNumber) {
        this.id = id;
        this.authorFullName = authorFullName;
        this.authorEmail = authorEmail;
        this.authorPhoneNumber = authorPhoneNumber;
    }

    public static Author create(AuthorFullName authorFullName, AuthorEmail authorEmail, AuthorPhoneNumber authorPhoneNumber)
    {
        return new Author(AuthorId.generateAuthorId(), authorFullName, authorEmail, authorPhoneNumber);
    }

    public static Author rehydrate(AuthorId id,AuthorFullName authorFullName, AuthorEmail authorEmail, AuthorPhoneNumber authorPhoneNumber)
    {
        return new Author(id, authorFullName, authorEmail, authorPhoneNumber);
    }

    //TODO -> Change email konus.

    public void rename(AuthorFullName newFullName) {
        this.authorFullName = requireFullName(newFullName);
    }

    public void changePhone(AuthorPhoneNumber newPhone) {
        this.authorPhoneNumber = newPhone;
    }

    private static AuthorFullName requireFullName(AuthorFullName fn) {
        return Objects.requireNonNull(fn, "Full name required");
    }

    private static AuthorEmail requireEmail(AuthorEmail em) {
        return Objects.requireNonNull(em, "Email required");
    }

    public AuthorId id() {
        return id;
    }

    public AuthorFullName authorFullName() {
        return authorFullName;
    }

    public AuthorEmail authorEmail() {
        return authorEmail;
    }

    public AuthorPhoneNumber authorPhoneNumber() {
        return authorPhoneNumber;
    }
}
