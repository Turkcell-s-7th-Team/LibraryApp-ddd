package com.turkcell.LibraryApp_ddd.application.reservation.mapper;

import com.turkcell.LibraryApp_ddd.application.reservation.command.CreateReservationCommand;
import com.turkcell.LibraryApp_ddd.application.reservation.dto.CreatedReservationResponse;
import com.turkcell.LibraryApp_ddd.domain.reservation.model.Reservation;
import org.springframework.stereotype.Component;

@Component
public class CreateReservationMapper {

    public Reservation toDomain(CreateReservationCommand command) {
        return Reservation.create(
                command.memberId(),
                command.bookId(),
                command.reservationDate(),
                command.dueDate()
        );
    }

    public CreatedReservationResponse toResponse(Reservation reservation) {
        return new CreatedReservationResponse(
                reservation.id().value(),
                reservation.memberId().value(),
                reservation.bookId().value(),
                reservation.reservationDate(),
                reservation.dueDate()
        );
    }
}
