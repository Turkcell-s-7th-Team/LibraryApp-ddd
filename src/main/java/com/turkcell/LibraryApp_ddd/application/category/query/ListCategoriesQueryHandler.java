package com.turkcell.LibraryApp_ddd.application.category.query;

import com.turkcell.LibraryApp_ddd.application.category.dto.CategoryResponse;
import com.turkcell.LibraryApp_ddd.core.cqrs.QueryHandler;
import com.turkcell.LibraryApp_ddd.domain.category.repository.CategoryRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ListCategoriesQueryHandler
        implements QueryHandler<ListCategoriesQuery, List<CategoryResponse>> {

    private final CategoryRepository categoryRepository;

    public ListCategoriesQueryHandler(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryResponse> handle(ListCategoriesQuery q) {
        int page = (q.pageIndex() < 0) ? 0 : q.pageIndex();
        int size = (q.pageSize() <= 0) ? 20 : q.pageSize();

        return categoryRepository.findAllPaged(page, size).stream()
                .map(c -> new CategoryResponse(
                        c.id().value(),
                        c.categoryName().value(),
                        c.categoryDescription().value()
                ))
                .toList();
    }
}
