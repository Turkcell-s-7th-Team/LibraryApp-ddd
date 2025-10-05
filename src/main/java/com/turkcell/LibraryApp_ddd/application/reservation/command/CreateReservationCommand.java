package com.turkcell.LibraryApp_ddd.application.reservation.command;

import com.turkcell.LibraryApp_ddd.application.reservation.dto.CreatedReservationResponse;
import com.turkcell.LibraryApp_ddd.core.cqrs.Command;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record CreateReservationCommand(
        @NotNull UUID memberId,
        @NotNull List<@NotNull UUID> bookIds,
        @NotNull LocalDate reservationDate,
        @NotNull LocalDate dueDate
) implements Command<CreatedReservationResponse> {
}
