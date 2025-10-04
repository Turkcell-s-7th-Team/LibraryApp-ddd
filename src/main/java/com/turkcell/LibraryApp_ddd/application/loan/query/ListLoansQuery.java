package com.turkcell.LibraryApp_ddd.application.loan.query;

import com.turkcell.LibraryApp_ddd.application.author.dto.AuthorResponse;
import com.turkcell.LibraryApp_ddd.application.loan.dto.LoanResponse;
import com.turkcell.LibraryApp_ddd.core.cqrs.Query;
import jakarta.validation.constraints.Min;

import java.util.List;

public record ListLoansQuery(@Min(0) Integer pageIndex,
                             @Min(1) Integer pageSize) implements Query<List<LoanResponse>> {
}
