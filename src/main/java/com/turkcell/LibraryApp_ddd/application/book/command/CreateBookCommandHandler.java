package com.turkcell.LibraryApp_ddd.application.book.command;

import com.turkcell.LibraryApp_ddd.application.book.dto.CreatedBookResponse;
import com.turkcell.LibraryApp_ddd.application.book.mapper.CreateBookMapper;
import com.turkcell.LibraryApp_ddd.core.cqrs.CommandHandler;
import com.turkcell.LibraryApp_ddd.domain.book.model.Book;
import com.turkcell.LibraryApp_ddd.domain.book.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateBookCommandHandler
        implements CommandHandler<CreateBookCommand, CreatedBookResponse> {

    private final BookRepository repository;
    private final CreateBookMapper mapper;

    public CreateBookCommandHandler(BookRepository repository, CreateBookMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public CreatedBookResponse handle(CreateBookCommand cmd) {
        Book saved = repository.save(mapper.toDomain(cmd));
        return new CreatedBookResponse(saved.id().value(), saved.title().value());
    }
}
