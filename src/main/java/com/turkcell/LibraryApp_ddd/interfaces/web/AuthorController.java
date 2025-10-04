package com.turkcell.LibraryApp_ddd.interfaces.web;

import com.turkcell.LibraryApp_ddd.application.author.command.CreateAuthorCommand;
import com.turkcell.LibraryApp_ddd.application.author.dto.AuthorResponse;
import com.turkcell.LibraryApp_ddd.application.author.dto.CreatedAuthorResponse;
import com.turkcell.LibraryApp_ddd.application.author.query.ListAuthorsQuery;
import com.turkcell.LibraryApp_ddd.core.cqrs.CommandHandler;
import com.turkcell.LibraryApp_ddd.core.cqrs.QueryHandler;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@Validated
public class AuthorController {

    private final QueryHandler<ListAuthorsQuery, List<AuthorResponse>> listAuthorsQueryHandler;
    private final CommandHandler<CreateAuthorCommand, CreatedAuthorResponse> createAuthorCommandHandler;

    public AuthorController(QueryHandler<ListAuthorsQuery, List<AuthorResponse>> listAuthorsQueryHandler, CommandHandler<CreateAuthorCommand, CreatedAuthorResponse> createAuthorCommandHandler) {
        this.listAuthorsQueryHandler = listAuthorsQueryHandler;
        this.createAuthorCommandHandler = createAuthorCommandHandler;
    }

    @GetMapping
    public List<AuthorResponse> getAuthors(@Valid ListAuthorsQuery query)
    {
        return listAuthorsQueryHandler.handle(query);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedAuthorResponse createAuthor(@Valid @RequestBody CreateAuthorCommand command)
    {
        return createAuthorCommandHandler.handle(command);
    }
}
