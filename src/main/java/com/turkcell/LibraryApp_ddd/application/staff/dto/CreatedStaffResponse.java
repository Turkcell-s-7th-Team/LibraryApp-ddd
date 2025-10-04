package com.turkcell.LibraryApp_ddd.application.staff.dto;

import java.util.UUID;

public record CreatedStaffResponse(
        UUID id,
        String name,
        String surname,
        String phone) {
}
