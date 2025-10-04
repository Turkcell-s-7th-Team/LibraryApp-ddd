package com.turkcell.LibraryApp_ddd.persistence.loan;

import com.turkcell.LibraryApp_ddd.domain.loan.model.Loan;
import com.turkcell.LibraryApp_ddd.domain.loan.model.LoanId;
import com.turkcell.LibraryApp_ddd.domain.member.model.MemberId;
import com.turkcell.LibraryApp_ddd.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Component;

@Component
public class LoanEntityMapper {

    public JpaLoanEntity toEntity(Loan loan)
    {
        JpaLoanEntity loanEntity = new JpaLoanEntity();
        loanEntity.setId(loan.id().value());
        loanEntity.setMemberId(loan.memberId().value());
        loanEntity.setLoanDate(loan.loanDate());
        loanEntity.setDueDate(loan.dueDate());
        loanEntity.setReturnDate(loan.returnDate());
        return loanEntity;
    }

    public Loan toDomain(JpaLoanEntity entity)
    {
        return Loan.rehydrate(
                new LoanId(entity.id()),
                new MemberId(entity.memberId()),
                entity.loanDate(),
                entity.dueDate(),
                entity.returnDate()
        );
    }
}
