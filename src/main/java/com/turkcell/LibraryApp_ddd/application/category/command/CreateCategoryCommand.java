package com.turkcell.LibraryApp_ddd.application.category.command;

import com.turkcell.LibraryApp_ddd.application.category.dto.CreatedCategoryResponse;
import com.turkcell.LibraryApp_ddd.core.cqrs.Command;

public record CreateCategoryCommand(String name, String description) implements Command<CreatedCategoryResponse> { }
