package com.turkcell.LibraryApp_ddd.application.author.command;

import com.turkcell.LibraryApp_ddd.application.author.dto.CreatedAuthorResponse;
import com.turkcell.LibraryApp_ddd.application.author.mapper.CreateAuthorMapper;
import com.turkcell.LibraryApp_ddd.core.cqrs.CommandHandler;
import com.turkcell.LibraryApp_ddd.domain.author.model.Author;
import com.turkcell.LibraryApp_ddd.domain.author.repository.AuthorRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateAuthorCommandHandler implements CommandHandler<CreateAuthorCommand, CreatedAuthorResponse> {
    private final AuthorRepository authorRepository;
    private final CreateAuthorMapper createAuthorMapper;

    public CreateAuthorCommandHandler(AuthorRepository authorRepository, CreateAuthorMapper createAuthorMapper) {
        this.authorRepository = authorRepository;
        this.createAuthorMapper = createAuthorMapper;
    }

    @Override
    public CreatedAuthorResponse handle(CreateAuthorCommand command) {
        Author author = createAuthorMapper.toDomain(command);
        author = authorRepository.save(author);
        return createAuthorMapper.toResponse(author);
    }
}
