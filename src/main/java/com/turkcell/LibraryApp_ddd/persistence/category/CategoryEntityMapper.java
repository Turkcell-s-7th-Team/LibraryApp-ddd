package com.turkcell.LibraryApp_ddd.persistence.category;

import com.turkcell.LibraryApp_ddd.domain.category.model.Category;
import com.turkcell.LibraryApp_ddd.domain.category.model.CategoryDescription;
import com.turkcell.LibraryApp_ddd.domain.category.model.CategoryId;
import com.turkcell.LibraryApp_ddd.domain.category.model.CategoryName;
import org.springframework.stereotype.Component;

@Component
public class CategoryEntityMapper {

    public JpaCategoryEntity toEntity(Category category) {
        JpaCategoryEntity e = new JpaCategoryEntity();
        e.setId(category.id().value());
        e.setName(category.categoryName().value());
        e.setDescription(category.categoryDescription().value());
        return e;
    }

    public Category toDomain(JpaCategoryEntity e) {
        return Category.rehydrate(
                new CategoryId(e.getId()),
                new CategoryName(e.getName()),
                new CategoryDescription(e.getDescription()) // <-- null ise VO exception atar
        );
    }
}
