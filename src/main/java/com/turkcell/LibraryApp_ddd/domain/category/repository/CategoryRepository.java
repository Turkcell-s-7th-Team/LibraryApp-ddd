package com.turkcell.LibraryApp_ddd.domain.category.repository;

import com.turkcell.LibraryApp_ddd.domain.category.model.Category;
import com.turkcell.LibraryApp_ddd.domain.category.model.CategoryId;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    Category save(Category category);
    Optional<Category> findById(CategoryId categoryId);
    List<Category> findAllPaged(Integer pageIndex, Integer pageSize);
    void delete(CategoryId categoryId);
}