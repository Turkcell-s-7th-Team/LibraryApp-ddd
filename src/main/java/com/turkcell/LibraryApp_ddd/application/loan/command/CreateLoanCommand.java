package com.turkcell.LibraryApp_ddd.application.loan.command;

import com.turkcell.LibraryApp_ddd.application.loan.dto.CreatedLoanResponse;
import com.turkcell.LibraryApp_ddd.core.cqrs.Command;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;
import java.util.UUID;

public record CreateLoanCommand(
        @NotNull UUID memberId,
        @NotNull @PastOrPresent LocalDate loanDate,
        @NotNull @FutureOrPresent LocalDate dueDate) implements Command<CreatedLoanResponse> {
}
