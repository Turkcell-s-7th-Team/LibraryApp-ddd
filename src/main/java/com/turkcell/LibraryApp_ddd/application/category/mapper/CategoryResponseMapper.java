package com.turkcell.LibraryApp_ddd.application.category.mapper;

import com.turkcell.LibraryApp_ddd.application.category.dto.CategoryResponse;
import com.turkcell.LibraryApp_ddd.domain.category.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryResponseMapper {
    public CategoryResponse toResponse(Category c) {
        return new CategoryResponse(
                c.id().value(),
                c.categoryName().value(),
                c.categoryDescription().value()
        );
    }
}
