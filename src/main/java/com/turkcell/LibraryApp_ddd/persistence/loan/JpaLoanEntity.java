package com.turkcell.LibraryApp_ddd.persistence.loan;

import com.turkcell.LibraryApp_ddd.domain.member.model.Member;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "loans")
public class JpaLoanEntity {

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(name="member_id", columnDefinition="uuid", nullable=false)
    private UUID memberId;

    @Column(name = "loan_date", nullable = false)
    private LocalDate loanDate;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    public UUID id() {
        return id;
    }

    public JpaLoanEntity setId(UUID id) {
        this.id = id;
        return this;
    }


    public UUID memberId() {
        return memberId;
    }

    public JpaLoanEntity setMemberId(UUID memberId) {
        this.memberId = memberId;
        return this;
    }

    public LocalDate loanDate() {
        return loanDate;
    }

    public JpaLoanEntity setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
        return this;
    }

    public LocalDate dueDate() {
        return dueDate;
    }

    public JpaLoanEntity setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public LocalDate returnDate() {
        return returnDate;
    }

    public JpaLoanEntity setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
        return this;
    }
}
