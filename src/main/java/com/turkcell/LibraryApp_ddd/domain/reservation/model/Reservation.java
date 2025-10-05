package com.turkcell.LibraryApp_ddd.domain.reservation.model;

import com.turkcell.LibraryApp_ddd.domain.book.model.Book;
import com.turkcell.LibraryApp_ddd.domain.book.model.BookId;
import com.turkcell.LibraryApp_ddd.domain.member.model.MemberId;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Reservation {

    private final ReservationId id;
    private final MemberId memberId;
    private Set<BookId> bookIds;
    private ReservationDate reservationDate;
    private DueDate dueDate;

    private Reservation(ReservationId id, MemberId memberId, Set<BookId> bookIds,
                        ReservationDate reservationDate, DueDate dueDate) {
        this.id = id;
        this.memberId = memberId;
        this.bookIds = bookIds != null ? new HashSet<>(bookIds) : new HashSet<>();
        this.reservationDate = reservationDate;
        this.dueDate = dueDate;
    }

    public static Reservation create(MemberId memberId, Set<BookId> bookIds, ReservationDate reservationDate, DueDate dueDate) {
        return new Reservation(ReservationId.generate(), memberId, bookIds, reservationDate, dueDate);
    }

    public static Reservation rehydrate(ReservationId id, MemberId memberId, Set<Book> books, ReservationDate reservationDate, DueDate dueDate) {
        Set<BookId> bookIds = new HashSet<>();
        if (books != null) {
            books.forEach(book -> bookIds.add(book.id()));
        }
        return new Reservation(id, memberId, bookIds, reservationDate, dueDate);
    }

    public ReservationId id() {
        return id;
    }

    public MemberId memberId() {
        return memberId;
    }

    public Set<BookId> bookIds() {
        return Collections.unmodifiableSet(bookIds);
    }

    public ReservationDate reservationDate() {
        return reservationDate;
    }

    public DueDate dueDate() {
        return dueDate;
    }

    public void addBook(BookId bookId) {
        this.bookIds.add(bookId);
    }

    public void removeBook(BookId bookId) {
        this.bookIds.remove(bookId);
    }

    public void setReservationDate(ReservationDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public void setDueDate(DueDate dueDate) {
        this.dueDate = dueDate;
    }
}
