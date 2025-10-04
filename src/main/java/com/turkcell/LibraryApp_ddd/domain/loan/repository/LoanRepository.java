package com.turkcell.LibraryApp_ddd.domain.loan.repository;

import com.turkcell.LibraryApp_ddd.domain.loan.model.Loan;
import com.turkcell.LibraryApp_ddd.domain.loan.model.LoanId;

import java.util.List;
import java.util.Optional;

public interface LoanRepository {

    Loan save(Loan loan);
    Optional<Loan> findById(LoanId loanId);
    List<Loan> findAllPaged(Integer pageIndex, Integer pageSize);
    void delete (LoanId loanId);
}
