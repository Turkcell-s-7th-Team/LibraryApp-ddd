package com.turkcell.LibraryApp_ddd.domain.reservation.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public record DueDate(LocalDate value) implements Serializable {

    public DueDate {
        Objects.requireNonNull(value, "DueDate cannot be null");
        if (value.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("DueDate cannot be in the past: " + value);
        }
    }

    public static DueDate fromDaysLater(int days) {
        return new DueDate(LocalDate.now().plusDays(days));
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
