package com.turkcell.LibraryApp_ddd.persistence.author;

import com.turkcell.LibraryApp_ddd.domain.author.model.*;
import org.springframework.stereotype.Component;

@Component
public class AuthorEntityMapper {

    public JpaAuthorEntity toEntity(Author author)
    {
        JpaAuthorEntity authorEntity = new JpaAuthorEntity();
        authorEntity.setId(author.id().value());
        authorEntity.setName(author.authorFullName().name());
        authorEntity.setSurname(author.authorFullName().surname());
        authorEntity.setEmail(author.authorEmail().email());
        authorEntity.setPhoneNumber(author.authorPhoneNumber().phoneNumber());
        return authorEntity;
    }

    public Author toDomain(JpaAuthorEntity entity)
    {
        return Author.rehydrate(
                new AuthorId(entity.id()),
                new AuthorFullName(entity.name(), entity.surname()),
                new AuthorEmail(entity.email()),
                new AuthorPhoneNumber(entity.phoneNumber())
        );
    }
}
