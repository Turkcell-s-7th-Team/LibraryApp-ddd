package com.turkcell.LibraryApp_ddd.application.category.mapper;

import com.turkcell.LibraryApp_ddd.application.category.command.CreateCategoryCommand;
import com.turkcell.LibraryApp_ddd.domain.category.model.Category;
import com.turkcell.LibraryApp_ddd.domain.category.model.CategoryDescription;
import com.turkcell.LibraryApp_ddd.domain.category.model.CategoryName;
import org.springframework.stereotype.Component;

@Component
public class CreateCategoryMapper {
    public Category toDomain(CreateCategoryCommand cmd) {
        return Category.create(
                new CategoryName(cmd.name()),
                new CategoryDescription(cmd.description())
        );
    }
}
