package com.turkcell.LibraryApp_ddd.domain.category.model;

import java.util.Objects;

public class Category {

    private final CategoryId id;
    private CategoryName categoryName;
    private CategoryDescription categoryDescription;

    public Category(CategoryId id, CategoryName categoryName, CategoryDescription categoryDescription) {
        this.id = Objects.requireNonNull(id, "Id cannot be null");
        this.categoryName = Objects.requireNonNull(categoryName, "Name cannot be null");
        this.categoryDescription = Objects.requireNonNull(categoryDescription, "Description cannot be null");
    }

    public static Category create(CategoryName categoryName, CategoryDescription categoryDescription) {
        return new Category(CategoryId.generateCategoryId(), categoryName, categoryDescription);
    }

    public static Category rehydrate(CategoryId id, CategoryName categoryName, CategoryDescription categoryDescription) {
        return new Category(id, categoryName, categoryDescription);
    }

    public void rename(CategoryName newName) {
        this.categoryName = Objects.requireNonNull(newName);
    }

    public void changeDescription(CategoryDescription newDescription) {
        this.categoryDescription = Objects.requireNonNull(newDescription);
    }

    public CategoryId id() { return id; }
    public CategoryName categoryName() { return categoryName; }
    public CategoryDescription categoryDescription() { return categoryDescription; }
}
