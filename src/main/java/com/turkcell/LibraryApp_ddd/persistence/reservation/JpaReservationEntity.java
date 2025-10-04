
package com.turkcell.LibraryApp_ddd.persistence.reservation;

import com.turkcell.LibraryApp_ddd.domain.book.model.BookId;
import com.turkcell.LibraryApp_ddd.domain.member.model.MemberId;
import com.turkcell.LibraryApp_ddd.domain.fine.model.Fine;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "reservations")
public class JpaReservationEntity {

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @NotNull
    @Column(name = "member_id", columnDefinition = "uuid", nullable = false)
    private UUID memberId;

    @ManyToMany
    @JoinTable(
            name = "reservation_books",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<BookId> books = new HashSet<>();

    @Column(name = "reservation_date", nullable = false)
    private LocalDate reservationDate;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @OneToMany
    @JoinColumn(name = "reservation_id")
    private Set<Fine> fines = new HashSet<>();

    public UUID id() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID memberId() {
        return memberId;
    }

    public void setMemberId(UUID memberId) {
        this.memberId = memberId;
    }

    public Set<BookId> books() {
        return books;
    }

    public void setBooks(Set<BookId> books) {
        this.books = books;
    }

    public LocalDate reservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalDate dueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Set<Fine> fines() {
        return fines;
    }

    public void setFines(Set<Fine> fines) {
        this.fines = fines;
    }
}
