package com.turkcell.LibraryApp_ddd.application.reservation.dto;

import java.time.LocalDate;
import java.util.UUID;

public record CreatedReservationResponse(
        UUID id,
        UUID memberId,
        UUID bookId,
        LocalDate reservationDate,
        LocalDate dueDate
) {
}
