package com.turkcell.LibraryApp_ddd.domain.reservation.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public record ReservationId(UUID value) implements Serializable {

    public ReservationId {
        Objects.requireNonNull(value, "Value for ReservationId cannot be null!");
    }

    public static ReservationId generate() {
        return new ReservationId(UUID.randomUUID());
    }
}
