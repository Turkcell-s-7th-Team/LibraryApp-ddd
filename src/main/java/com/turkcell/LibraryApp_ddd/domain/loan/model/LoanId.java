package com.turkcell.LibraryApp_ddd.domain.loan.model;

import com.turkcell.LibraryApp_ddd.domain.author.model.AuthorId;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public record LoanId(UUID value) implements Serializable {

    public LoanId{
        Objects.requireNonNull(value, "Value for LoanId cannot be null");
    }

    public static LoanId generateLoanId() {
        return new LoanId(UUID.randomUUID());
    }
}
