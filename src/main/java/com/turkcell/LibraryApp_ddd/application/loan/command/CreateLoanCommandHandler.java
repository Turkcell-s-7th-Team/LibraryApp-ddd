package com.turkcell.LibraryApp_ddd.application.loan.command;

import com.turkcell.LibraryApp_ddd.application.loan.dto.CreatedLoanResponse;
import com.turkcell.LibraryApp_ddd.application.loan.mapper.CreateLoanMapper;
import com.turkcell.LibraryApp_ddd.core.cqrs.CommandHandler;
import com.turkcell.LibraryApp_ddd.domain.loan.model.Loan;
import com.turkcell.LibraryApp_ddd.domain.loan.repository.LoanRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateLoanCommandHandler implements CommandHandler<CreateLoanCommand, CreatedLoanResponse> {
    private final LoanRepository loanRepository;
    private final CreateLoanMapper createLoanMapper;

    public CreateLoanCommandHandler(LoanRepository loanRepository, CreateLoanMapper createLoanMapper) {
        this.loanRepository = loanRepository;
        this.createLoanMapper = createLoanMapper;
    }

    @Override
    public CreatedLoanResponse handle(CreateLoanCommand command) {
        Loan loan = createLoanMapper.toDomain(command);
        loan = loanRepository.save(loan);
        return createLoanMapper.toResponse(loan);
    }
}
