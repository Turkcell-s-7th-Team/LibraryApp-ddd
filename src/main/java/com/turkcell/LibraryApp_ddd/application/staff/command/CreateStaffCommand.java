package com.turkcell.LibraryApp_ddd.application.staff.command;

import com.turkcell.LibraryApp_ddd.application.staff.dto.CreatedStaffResponse;
import com.turkcell.LibraryApp_ddd.core.cqrs.Command;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateStaffCommand(
        @NotBlank @Size(min = 3, max = 255) String name,
        @NotBlank @Size(min = 3, max = 255) String surname,
        @NotBlank String phone
) implements Command<CreatedStaffResponse> {
}
