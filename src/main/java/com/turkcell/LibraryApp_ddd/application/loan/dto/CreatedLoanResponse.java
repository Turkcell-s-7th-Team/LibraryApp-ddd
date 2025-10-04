package com.turkcell.LibraryApp_ddd.application.loan.dto;

import java.time.LocalDate;
import java.util.UUID;

public record CreatedLoanResponse(
        UUID id,
        UUID memberId,
        LocalDate loanDate,
        LocalDate dueDate
) {
}
