package com.turkcell.LibraryApp_ddd.application.reservation.dto;

import java.time.LocalDate;
import java.util.UUID;

public record ReservationResponse(
        UUID id,
        UUID memberId,
        UUID bookId,
        LocalDate reservationDate,
        LocalDate dueDate
) {
}
