package com.turkcell.LibraryApp_ddd.domain.staff.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public record StaffId(UUID value) implements Serializable {

    public StaffId {
        Objects.requireNonNull(value, "Value for StaffId cannot be null!");
    }

    public static StaffId generate() {
        return new StaffId(UUID.randomUUID());
    }
}
