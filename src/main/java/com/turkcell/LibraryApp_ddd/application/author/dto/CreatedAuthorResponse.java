package com.turkcell.LibraryApp_ddd.application.author.dto;

import java.util.UUID;

public record CreatedAuthorResponse(UUID id, String name, String surname) {
}
