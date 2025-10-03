package com.turkcell.LibraryApp_ddd.application.author.mapper;

import com.turkcell.LibraryApp_ddd.application.author.command.CreateAuthorCommand;
import com.turkcell.LibraryApp_ddd.application.author.dto.CreatedAuthorResponse;
import com.turkcell.LibraryApp_ddd.domain.author.model.Author;
import com.turkcell.LibraryApp_ddd.domain.author.model.AuthorEmail;
import com.turkcell.LibraryApp_ddd.domain.author.model.AuthorFullName;
import com.turkcell.LibraryApp_ddd.domain.author.model.AuthorPhoneNumber;
import org.springframework.stereotype.Component;

@Component
public class CreateAuthorMapper {

    public Author toDomain(CreateAuthorCommand command)
    {
        return Author.create(
                new AuthorFullName(command.name(), command.surname()),
                new AuthorEmail(command.email()),
                new AuthorPhoneNumber(command.phoneNumber())
        );
    }

    public CreatedAuthorResponse toResponse(Author author)
    {
        return new CreatedAuthorResponse(
                author.id().value(),
                author.authorFullName().name(),
                author.authorFullName().surname()
        );
    }
}
