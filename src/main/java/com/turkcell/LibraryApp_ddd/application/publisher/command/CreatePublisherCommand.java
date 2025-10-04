package com.turkcell.LibraryApp_ddd.application.publisher.command;

import com.turkcell.LibraryApp_ddd.application.publisher.dto.CreatedPublisherResponse;
import com.turkcell.LibraryApp_ddd.core.cqrs.Command;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreatePublisherCommand(
        @NotBlank @Size(min = 3, max = 255) String name,
        @NotBlank @Size(min = 3, max = 255) String address
) implements Command<CreatedPublisherResponse> {
}
