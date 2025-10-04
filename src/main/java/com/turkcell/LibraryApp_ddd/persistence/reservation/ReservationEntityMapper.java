package com.turkcell.LibraryApp_ddd.persistence.reservation;

import com.turkcell.LibraryApp_ddd.domain.book.model.Book;
import com.turkcell.LibraryApp_ddd.domain.book.model.BookId;
import com.turkcell.LibraryApp_ddd.domain.fine.model.Fine;
import com.turkcell.LibraryApp_ddd.domain.reservation.model.Reservation;
import com.turkcell.LibraryApp_ddd.domain.reservation.model.ReservationId;
import com.turkcell.LibraryApp_ddd.domain.member.model.MemberId;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ReservationEntityMapper {

    public JpaReservationEntity toEntity(Reservation reservation) {
        JpaReservationEntity entity = new JpaReservationEntity();
        entity.setId(reservation.id().value());
        entity.setMemberId(reservation.memberId().value());
        entity.setReservationDate(reservation.reservationDate());
        entity.setDueDate(reservation.dueDate());
        entity.setBooksIds = reservation.bookIds().stream().map(BookId::value).collect(Collectors.toSet());
        entity.setFines(reservation.fines().stream().collect(Collectors.toSet()));
        return entity;
    }

    public Reservation toDomain(JpaReservationEntity entity, Set<Book> books, Set<Fine> fines) {
        return Reservation.rehydrate(
                new ReservationId(entity.id()),
                new MemberId(entity.memberId()),
                books,
                entity.reservationDate(),
                entity.dueDate(),
                fines != null ? fines : new HashSet<>()
        );
    }
}
