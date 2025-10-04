package com.turkcell.LibraryApp_ddd.application.category.command;

import com.turkcell.LibraryApp_ddd.application.category.dto.CreatedCategoryResponse;
import com.turkcell.LibraryApp_ddd.core.cqrs.CommandHandler;
import com.turkcell.LibraryApp_ddd.domain.category.model.Category;
import com.turkcell.LibraryApp_ddd.domain.category.model.CategoryDescription;
import com.turkcell.LibraryApp_ddd.domain.category.model.CategoryId;
import com.turkcell.LibraryApp_ddd.domain.category.model.CategoryName;
import com.turkcell.LibraryApp_ddd.domain.category.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CreateCategoryCommandHandler
        implements CommandHandler<CreateCategoryCommand, CreatedCategoryResponse> {

    private final CategoryRepository categoryRepository;

    public CreateCategoryCommandHandler(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    @Override
    public CreatedCategoryResponse handle(CreateCategoryCommand cmd) {
        Category category = new Category(
                new CategoryId(UUID.randomUUID()),
                new CategoryName(cmd.name()),
                new CategoryDescription(cmd.description())
        );

        Category saved = categoryRepository.save(category);

        return new CreatedCategoryResponse(
                saved.id().value(),
                saved.categoryName().value(),
                saved.categoryDescription().value()
        );
    }
}
