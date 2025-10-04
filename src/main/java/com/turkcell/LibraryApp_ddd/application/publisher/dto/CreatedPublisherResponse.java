package com.turkcell.LibraryApp_ddd.application.publisher.dto;

import java.util.UUID;

public record CreatedPublisherResponse (UUID id, String name, String address) {
}
