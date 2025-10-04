package com.turkcell.LibraryApp_ddd.application.loan.mapper;

import com.turkcell.LibraryApp_ddd.application.loan.dto.LoanResponse;
import com.turkcell.LibraryApp_ddd.domain.loan.model.Loan;
import org.springframework.stereotype.Component;

@Component
public class LoanResponseMapper {

    public LoanResponse toResponse(Loan loan){
        return new LoanResponse(
                loan.id().value(),
                loan.memberId().value(),
                loan.loanDate(),
                loan.dueDate()
        );
    }
}
