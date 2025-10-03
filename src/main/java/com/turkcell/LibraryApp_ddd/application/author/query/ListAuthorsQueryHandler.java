package com.turkcell.LibraryApp_ddd.application.author.query;

import com.turkcell.LibraryApp_ddd.application.author.dto.AuthorResponse;
import com.turkcell.LibraryApp_ddd.application.author.mapper.AuthorResponseMapper;
import com.turkcell.LibraryApp_ddd.core.cqrs.QueryHandler;
import com.turkcell.LibraryApp_ddd.domain.author.repository.AuthorRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListAuthorsQueryHandler implements QueryHandler<ListAuthorsQuery, List<AuthorResponse>> {
    private final AuthorRepository authorRepository;
    private final AuthorResponseMapper authorResponseMapper;

    public ListAuthorsQueryHandler(AuthorRepository authorRepository, AuthorResponseMapper authorResponseMapper) {
        this.authorRepository = authorRepository;
        this.authorResponseMapper = authorResponseMapper;
    }

    @Override
    public List<AuthorResponse> handle(ListAuthorsQuery query) {
        return authorRepository
                .findAllPaged(query.pageIndex(), query.pageSize())
                .stream()
                .map(authorResponseMapper::toResponse)
                .toList();
    }
}
