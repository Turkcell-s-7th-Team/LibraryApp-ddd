package com.turkcell.LibraryApp_ddd.application.book.query;

import com.turkcell.LibraryApp_ddd.application.book.dto.BookResponse;
import com.turkcell.LibraryApp_ddd.core.cqrs.Query;

import java.util.List;

public record ListBooksQuery(int pageIndex, int pageSize)
        implements Query<List<BookResponse>> { }
