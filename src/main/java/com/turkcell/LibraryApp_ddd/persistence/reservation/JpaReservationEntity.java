package com.turkcell.LibraryApp_ddd.persistence.reservation;

import com.turkcell.LibraryApp_ddd.persistence.book.JpaBookEntity;
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
    UUID id;

    @NotNull
    @Column(name = "member_id", columnDefinition = "uuid", nullable = false)
    private UUID memberId;

    @ManyToMany
    @JoinTable(
            name = "reservation_books",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<JpaBookEntity> books = new HashSet<>();

    @Column(name = "reservation_date", nullable = false)
    private LocalDate reservationDate;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getMemberId() {
        return memberId;
    }

    public void setMemberId(UUID memberId) {
        this.memberId = memberId;
    }

    public Set<JpaBookEntity> getBooks() {
        return books;
    }

    public void setBooks(Set<JpaBookEntity> books) {
        this.books = books;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
