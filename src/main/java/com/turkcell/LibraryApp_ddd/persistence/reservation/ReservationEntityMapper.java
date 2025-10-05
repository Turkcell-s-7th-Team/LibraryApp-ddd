package com.turkcell.LibraryApp_ddd.persistence.reservation;

import com.turkcell.LibraryApp_ddd.domain.book.model.Book;
import com.turkcell.LibraryApp_ddd.domain.book.model.BookId;
import com.turkcell.LibraryApp_ddd.domain.member.model.MemberId;
import com.turkcell.LibraryApp_ddd.domain.reservation.model.DueDate;
import com.turkcell.LibraryApp_ddd.domain.reservation.model.Reservation;
import com.turkcell.LibraryApp_ddd.domain.reservation.model.ReservationDate;
import com.turkcell.LibraryApp_ddd.domain.reservation.model.ReservationId;
import com.turkcell.LibraryApp_ddd.persistence.book.JpaBookEntity;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ReservationEntityMapper {

    public JpaReservationEntity toEntity(Reservation reservation) {
        JpaReservationEntity entity = new JpaReservationEntity();
        entity.setId(reservation.id().value());
        entity.setMemberId(reservation.memberId().value());
        entity.setReservationDate(reservation.reservationDate().value());
        entity.setDueDate(reservation.dueDate().value());
        entity.setBooks(reservation.bookIds().stream()
                .map(bookId -> {
                    var bookEntity = new JpaBookEntity(); // varsayalım boş entity oluşturuyoruz, sadece ID kullanacağız
                    bookEntity.setId(bookId.value());
                    return bookEntity;
                })
                .collect(Collectors.toSet()));
        return entity;
    }

    public Reservation toDomain(JpaReservationEntity entity, Set<Book> books) {
        return Reservation.rehydrate(
                new ReservationId(entity.getId()),
                new MemberId(entity.getMemberId()),
                books,
                new ReservationDate(entity.getReservationDate()),
                new DueDate(entity.getDueDate())
        );
    }
}
