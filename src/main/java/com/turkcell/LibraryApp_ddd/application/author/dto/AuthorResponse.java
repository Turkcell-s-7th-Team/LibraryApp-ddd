package com.turkcell.LibraryApp_ddd.application.author.dto;


import java.util.UUID;

public record AuthorResponse(
        UUID id, String name, String surname, String email, String phoneNumber) {
}
