package com.turkcell.LibraryApp_ddd.domain.publisher.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public record PublisherId(UUID value) implements Serializable {
    public PublisherId {
        Objects.requireNonNull(value, "value must not be null");
    }
    public static PublisherId generate(){
        return new PublisherId(UUID.randomUUID());
    }
}
