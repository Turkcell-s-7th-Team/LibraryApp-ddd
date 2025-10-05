package com.turkcell.LibraryApp_ddd.application.reservation.mapper;

import com.turkcell.LibraryApp_ddd.application.reservation.command.CreateReservationCommand;
import com.turkcell.LibraryApp_ddd.application.reservation.dto.CreatedReservationResponse;
import com.turkcell.LibraryApp_ddd.domain.book.model.BookId;
import com.turkcell.LibraryApp_ddd.domain.member.model.MemberId;
import com.turkcell.LibraryApp_ddd.domain.reservation.model.DueDate;
import com.turkcell.LibraryApp_ddd.domain.reservation.model.Reservation;
import com.turkcell.LibraryApp_ddd.domain.reservation.model.ReservationDate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CreateReservationMapper {

    public Reservation toDomain(CreateReservationCommand command) {
        Set<BookId> bookIds = command.bookIds().stream()
                .map(BookId::new)
                .collect(Collectors.toSet());

        return Reservation.create(
                new MemberId(command.memberId()),
                bookIds,
                new ReservationDate(command.reservationDate()),
                new DueDate(command.dueDate())
        );
    }

    public CreatedReservationResponse toResponse(Reservation reservation) {
        Set<UUID> bookIds = reservation.bookIds().stream()
                .map(BookId::value)
                .collect(Collectors.toSet());

        return new CreatedReservationResponse(
                reservation.id().value(),
                reservation.memberId().value(),
                (List<UUID>) bookIds,
                reservation.reservationDate().value(),
                reservation.dueDate().value()
        );
    }
}
