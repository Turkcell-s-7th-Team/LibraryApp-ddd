package com.turkcell.LibraryApp_ddd.domain.reservation.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public record ReservationDate(LocalDate value) implements Serializable {

    public ReservationDate {
        Objects.requireNonNull(value, "ReservationDate cannot be null");
        if (value.isAfter(LocalDate.now().plusYears(1))) {
            throw new IllegalArgumentException("ReservationDate cannot be more than 1 year in the future: " + value);
        }
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
