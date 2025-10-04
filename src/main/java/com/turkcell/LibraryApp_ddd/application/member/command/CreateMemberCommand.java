package com.turkcell.LibraryApp_ddd.application.member.command;

import com.turkcell.LibraryApp_ddd.application.member.dto.CreatedMemberResponse;
import com.turkcell.LibraryApp_ddd.core.cqrs.Command;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CreateMemberCommand(@NotBlank @Size(min = 3, max = 255) String name,
                                  @NotBlank @Size(min = 3, max = 255) String surname,
                                  @Email String email,
                                  @NotBlank String phone,
                                  @NotBlank @Size(min = 3, max = 255) String address,
                                  LocalDate membershipDate, String membershipLevel)
        implements Command<CreatedMemberResponse> {
}

