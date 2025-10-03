package com.turkcell.LibraryApp_ddd.persistence.author;

import com.turkcell.LibraryApp_ddd.domain.author.model.Author;
import com.turkcell.LibraryApp_ddd.domain.author.model.AuthorId;
import com.turkcell.LibraryApp_ddd.domain.author.repository.AuthorRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepositoryAdapter implements AuthorRepository {

    private final SpringDataAuthorRepository repository;
    private final AuthorEntityMapper authorEntityMapper;

    public AuthorRepositoryAdapter(SpringDataAuthorRepository repository, AuthorEntityMapper authorEntityMapper) {
        this.repository = repository;
        this.authorEntityMapper = authorEntityMapper;
    }

    @Override
    public Author save(Author author) {
        JpaAuthorEntity entity = authorEntityMapper.toEntity(author);
        entity = repository.save(entity);
        return authorEntityMapper.toDomain(entity);
    }

    @Override
    public Optional<Author> findById(AuthorId authorId) {
        return repository
                .findById(authorId.value())
                .map(authorEntityMapper::toDomain);
    }

    @Override
    public List<Author> findAllPaged(Integer pageIndex, Integer pageSize) {
        return repository
                .findAll(PageRequest.of(pageIndex, pageSize))
                .stream()
                .map(authorEntityMapper::toDomain)
                .toList();
    }

    @Override
    public void delete(AuthorId authorId) {
        repository.deleteById(authorId.value());
    }
}
