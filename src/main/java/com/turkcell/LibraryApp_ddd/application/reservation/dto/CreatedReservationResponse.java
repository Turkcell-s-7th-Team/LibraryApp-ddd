package com.turkcell.LibraryApp_ddd.application.reservation.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record CreatedReservationResponse(
        UUID id,
        UUID memberId,
        List<UUID> bookIds,
        LocalDate reservationDate,
        LocalDate dueDate
) {
}
