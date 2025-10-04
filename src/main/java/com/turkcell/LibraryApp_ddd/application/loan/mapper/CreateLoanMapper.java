package com.turkcell.LibraryApp_ddd.application.loan.mapper;

import com.turkcell.LibraryApp_ddd.application.loan.command.CreateLoanCommand;
import com.turkcell.LibraryApp_ddd.application.loan.dto.CreatedLoanResponse;
import com.turkcell.LibraryApp_ddd.domain.loan.model.Loan;
import com.turkcell.LibraryApp_ddd.domain.loan.model.LoanId;
import com.turkcell.LibraryApp_ddd.domain.member.model.MemberId;
import org.springframework.stereotype.Component;

@Component
public class CreateLoanMapper {

    public Loan toDomain(CreateLoanCommand command)
    {
        return Loan.create(
                new MemberId(command.memberId()),
                command.loanDate(),
                command.dueDate(),
                null
        );

    }

    public CreatedLoanResponse toResponse(Loan loan)
    {
        return new CreatedLoanResponse(
                loan.id().value(),
                loan.memberId().value(),
                loan.loanDate(),
                loan.dueDate()
        );
    }
}
