package com.turkcell.LibraryApp_ddd.domain.author.repository;

import com.turkcell.LibraryApp_ddd.domain.author.model.Author;
import com.turkcell.LibraryApp_ddd.domain.author.model.AuthorId;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    Author save(Author author);
    Optional<Author> findById(AuthorId authorId);
    List<Author> findAllPaged(Integer pageIndex, Integer pageSize);
    void delete(AuthorId authorId);
}
