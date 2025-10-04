package com.turkcell.LibraryApp_ddd.application.category.dto;

import java.util.UUID;

public record CreatedCategoryResponse(UUID id, String name, String description) { }