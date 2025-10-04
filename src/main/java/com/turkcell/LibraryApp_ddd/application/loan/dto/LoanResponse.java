package com.turkcell.LibraryApp_ddd.application.loan.dto;

import java.time.LocalDate;
import java.util.UUID;

public record LoanResponse(
        UUID id, UUID memberId, LocalDate localDate, LocalDate dueDate
) {
}
