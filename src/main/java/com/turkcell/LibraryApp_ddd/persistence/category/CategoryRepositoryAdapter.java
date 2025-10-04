package com.turkcell.LibraryApp_ddd.persistence.category;

import com.turkcell.LibraryApp_ddd.domain.category.model.Category;
import com.turkcell.LibraryApp_ddd.domain.category.model.CategoryId;
import com.turkcell.LibraryApp_ddd.domain.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryAdapter implements CategoryRepository {
    private static final Logger log = LoggerFactory.getLogger(CategoryRepositoryAdapter.class);

    private final SpringDataCategoryRepository jpa;
    private final CategoryEntityMapper mapper;

    @Override
    @Transactional
    public Category save(Category category) {

        JpaCategoryEntity entity = mapper.toEntity(category);

        log.debug("toEntity => id={}, name='{}', desc='{}'",
                entity.getId(), entity.getName(), entity.getDescription());

        JpaCategoryEntity saved = jpa.save(entity);

        log.debug("fromJPA => id={}, name='{}', desc='{}'",
                saved.getId(), saved.getName(), saved.getDescription());

        // Entity -> Domain
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Category> findById(CategoryId categoryId) {
        return Optional.empty();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> findAllPaged(Integer pageIndex, Integer pageSize) {
        int p = (pageIndex == null || pageIndex < 0) ? 0 : pageIndex;
        int s = (pageSize == null || pageSize <= 0) ? 20 : pageSize;

        var page = jpa.findAll(PageRequest.of(p, s));
        return page.getContent().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(CategoryId categoryId) {

    }
}
