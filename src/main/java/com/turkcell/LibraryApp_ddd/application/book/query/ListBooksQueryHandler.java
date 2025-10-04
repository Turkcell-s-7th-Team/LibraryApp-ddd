package com.turkcell.LibraryApp_ddd.application.book.query;

import com.turkcell.LibraryApp_ddd.application.book.dto.BookResponse;
import com.turkcell.LibraryApp_ddd.application.book.mapper.BookResponseMapper;
import com.turkcell.LibraryApp_ddd.core.cqrs.QueryHandler;
import com.turkcell.LibraryApp_ddd.domain.book.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListBooksQueryHandler
        implements QueryHandler<ListBooksQuery, List<BookResponse>> {

    private final BookRepository repository;
    private final BookResponseMapper mapper;

    public ListBooksQueryHandler(BookRepository repository, BookResponseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<BookResponse> handle(ListBooksQuery q) {
        int page = Math.max(q.pageIndex(), 0);
        int size = Math.max(q.pageSize(), 1);
        return repository.findAllPaged(page, size).stream()
                .map(mapper::toResponse)
                .toList();
    }
}
