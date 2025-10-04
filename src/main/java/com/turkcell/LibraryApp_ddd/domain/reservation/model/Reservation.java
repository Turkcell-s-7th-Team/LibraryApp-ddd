package com.turkcell.LibraryApp_ddd.domain.reservation.model;

import com.turkcell.LibraryApp_ddd.domain.book.model.Book;
import com.turkcell.LibraryApp_ddd.domain.book.model.BookId;
import com.turkcell.LibraryApp_ddd.domain.fine.model.Fine;
import com.turkcell.LibraryApp_ddd.domain.member.model.MemberId;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Reservation {

    private final ReservationId id;
    private final MemberId memberId;
    private Set<Book> books;
    private LocalDate reservationDate;
    private LocalDate dueDate;
    private Set<Fine> fines;

    private Reservation(ReservationId id, MemberId memberId, Set<Book> books, LocalDate reservationDate, LocalDate dueDate, Set<Fine> fines) {
        this.id = id;
        this.memberId = memberId;
        this.books = books != null ? books : new HashSet<>();
        this.reservationDate = reservationDate;
        this.dueDate = dueDate;
        this.fines = fines != null ? fines : new HashSet<>();
    }

    public static Reservation create(MemberId memberId, Set<Book> books, LocalDate reservationDate, LocalDate dueDate) {
        return new Reservation(
                ReservationId.generate(),
                memberId,
                books,
                reservationDate,
                dueDate,
                new HashSet<>()
        );
    }

    public static Reservation rehydrate(ReservationId id, MemberId memberId, Set<Book> books, LocalDate reservationDate, LocalDate dueDate, Set<Fine> fines) {
        return new Reservation(
                id,
                memberId,
                books,
                reservationDate,
                dueDate,
                fines
        );
    }

    public ReservationId id() {
        return id;
    }

    public MemberId memberId() {
        return memberId;
    }

    public Set<Book> books() {
        return books;
    }

    public Set<BookId> bookIds() {
        Set<BookId> ids = new HashSet<>();
        for (Book book : books) {
            ids.add(book.id());
        }
        return ids;
    }

    public LocalDate reservationDate() {
        return reservationDate;
    }

    public LocalDate dueDate() {
        return dueDate;
    }

    public Set<Fine> fines() {
        return fines;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void addFine(Fine fine) {
        this.fines.add(fine);
    }
}
