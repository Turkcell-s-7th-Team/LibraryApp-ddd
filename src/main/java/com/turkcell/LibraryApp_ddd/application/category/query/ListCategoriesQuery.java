package com.turkcell.LibraryApp_ddd.application.category.query;

import com.turkcell.LibraryApp_ddd.application.category.dto.CategoryResponse;
import com.turkcell.LibraryApp_ddd.core.cqrs.Query;

import java.util.List;

public record ListCategoriesQuery(int pageIndex, int pageSize) implements Query<List<CategoryResponse>> { }
