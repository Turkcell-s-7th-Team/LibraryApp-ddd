package com.turkcell.LibraryApp_ddd.application.reservation.mapper;

import com.turkcell.LibraryApp_ddd.application.reservation.dto.ReservationResponse;
import com.turkcell.LibraryApp_ddd.domain.reservation.model.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationResponseMapper {

    public ReservationResponse toResponse(Reservation reservation) {
        return new ReservationResponse(
                reservation.id().value(),
                reservation.memberId().value(),
                reservation.bookId().value(),
                reservation.reservationDate(),
                reservation.dueDate()
        );
    }
}
