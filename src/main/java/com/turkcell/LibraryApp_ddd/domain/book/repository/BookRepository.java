package com.turkcell.LibraryApp_ddd.domain.book.repository;

import com.turkcell.LibraryApp_ddd.domain.book.model.Book;
import com.turkcell.LibraryApp_ddd.domain.book.model.BookId;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book save(Book book);
    Optional<Book> findById(BookId id);
    List<Book> findAllPaged(Integer pageIndex, Integer pageSize);
    void delete(BookId id);
}
