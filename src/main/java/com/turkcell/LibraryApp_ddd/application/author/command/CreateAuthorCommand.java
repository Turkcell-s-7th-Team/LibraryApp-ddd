package com.turkcell.LibraryApp_ddd.application.author.command;

import com.turkcell.LibraryApp_ddd.application.author.dto.CreatedAuthorResponse;
import com.turkcell.LibraryApp_ddd.core.cqrs.Command;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateAuthorCommand(
        @NotBlank @Size(min=3,max=255)String name,
        @NotBlank @Size(min=3,max=255)String surname,
        @NotBlank @Size(min=3,max=255)String email,
        @NotBlank String phoneNumber) implements Command<CreatedAuthorResponse> {

}
