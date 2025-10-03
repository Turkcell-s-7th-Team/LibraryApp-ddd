package com.turkcell.LibraryApp_ddd.application.author.mapper;

import com.turkcell.LibraryApp_ddd.application.author.dto.AuthorResponse;
import com.turkcell.LibraryApp_ddd.domain.author.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorResponseMapper {

    public AuthorResponse toResponse(Author author)
    {
        return new AuthorResponse(
                author.id().value(),
                author.authorFullName().name(),
                author.authorFullName().surname(),
                author.authorEmail().email(),
                author.authorPhoneNumber().phoneNumber()
        );
    }
}
