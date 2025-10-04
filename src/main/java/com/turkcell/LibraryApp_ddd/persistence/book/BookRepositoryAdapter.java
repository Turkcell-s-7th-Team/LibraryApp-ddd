package com.turkcell.LibraryApp_ddd.persistence.book;

import com.turkcell.LibraryApp_ddd.domain.book.model.Book;
import com.turkcell.LibraryApp_ddd.domain.book.model.BookId;
import com.turkcell.LibraryApp_ddd.domain.book.repository.BookRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryAdapter implements BookRepository {

    private final SpringDataBookRepository jpaRepository;
    private final BookEntityMapper mapper;

    public BookRepositoryAdapter(SpringDataBookRepository jpaRepository, BookEntityMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Book save(Book book) {
        var saved = jpaRepository.save(mapper.toEntity(book));
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Book> findById(BookId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<Book> findAllPaged(Integer pageIndex, Integer pageSize) {
        return jpaRepository.findAll(PageRequest.of(pageIndex, pageSize))
                .stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(BookId id) {
        jpaRepository.deleteById(id.value());
    }
}
