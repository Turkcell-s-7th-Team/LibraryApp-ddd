package com.turkcell.LibraryApp_ddd.domain.loan.model;

import com.turkcell.LibraryApp_ddd.domain.member.model.Member;
import com.turkcell.LibraryApp_ddd.domain.member.model.MemberId;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Loan {

    private final LoanId id;
    private final MemberId memberId;
    //private Book book;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    //private Staff staff;


    public Loan(LoanId id, MemberId memberId, LocalDate loanDate, LocalDate dueDate, LocalDate returnDate) {
        this.id = id;
        this.memberId = memberId;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    public static Loan create(MemberId memberId, LocalDate loanDate, LocalDate dueDate, LocalDate returnDate)
    {
        if (returnDate != null) {
            throw new IllegalArgumentException("Return date must be null on creation");
        }
        return new Loan(LoanId.generateLoanId(),memberId, loanDate, dueDate, returnDate);
    }

    public static Loan rehydrate(LoanId id, MemberId memberId, LocalDate loanDate, LocalDate dueDate, LocalDate returnDate)
    {
        return new Loan(id, memberId, loanDate, dueDate, returnDate);
    }

    private static Member requireMember(Member m) {
        return Objects.requireNonNull(m, "Member required");
    }

    private static LocalDate requireLoanDate(LocalDate d) {
        return Objects.requireNonNull(d, "Loan date required");
    }

    private static LocalDate requireDueDate(LocalDate d) {
        return Objects.requireNonNull(d, "Due date required");
    }

    private static void validateDateOrder(LocalDate loanDate, LocalDate dueDate, LocalDate returnDate) {
        if (loanDate.isAfter(dueDate)) {
            throw new IllegalArgumentException("Loan date must be on/before due date");
        }
        if (returnDate != null && returnDate.isBefore(loanDate)) {
            throw new IllegalArgumentException("Return date cannot be before loan date");
        }
    }

    public LoanId id() {
        return id;
    }

    public MemberId memberId() {
        return memberId;
    }

    public LocalDate loanDate() {
        return loanDate;
    }

    public LocalDate dueDate() {
        return dueDate;
    }

    public LocalDate returnDate() {
        return returnDate;
    }
}
