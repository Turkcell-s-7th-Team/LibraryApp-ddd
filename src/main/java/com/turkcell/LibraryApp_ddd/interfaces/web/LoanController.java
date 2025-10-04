package com.turkcell.LibraryApp_ddd.interfaces.web;

import com.turkcell.LibraryApp_ddd.application.author.command.CreateAuthorCommand;
import com.turkcell.LibraryApp_ddd.application.author.dto.AuthorResponse;
import com.turkcell.LibraryApp_ddd.application.author.dto.CreatedAuthorResponse;
import com.turkcell.LibraryApp_ddd.application.author.query.ListAuthorsQuery;
import com.turkcell.LibraryApp_ddd.application.loan.command.CreateLoanCommand;
import com.turkcell.LibraryApp_ddd.application.loan.dto.CreatedLoanResponse;
import com.turkcell.LibraryApp_ddd.application.loan.dto.LoanResponse;
import com.turkcell.LibraryApp_ddd.application.loan.query.ListLoansQuery;
import com.turkcell.LibraryApp_ddd.core.cqrs.CommandHandler;
import com.turkcell.LibraryApp_ddd.core.cqrs.QueryHandler;
import com.turkcell.LibraryApp_ddd.domain.loan.model.Loan;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
@Validated
public class LoanController {

    private final QueryHandler<ListLoansQuery, List<LoanResponse>> listLoansQueryHandler;
    private final CommandHandler<CreateLoanCommand, CreatedLoanResponse> createLoanCommandHandler;

    public LoanController(QueryHandler<ListLoansQuery, List<LoanResponse>> listLoansQueryHandler, CommandHandler<CreateLoanCommand, CreatedLoanResponse> createLoanCommandHandler) {
        this.listLoansQueryHandler = listLoansQueryHandler;
        this.createLoanCommandHandler = createLoanCommandHandler;
    }

    @GetMapping
    public List<LoanResponse> getLoans(@Valid ListLoansQuery query)
    {
        return listLoansQueryHandler.handle(query);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedLoanResponse createLoan(@Valid @RequestBody CreateLoanCommand command)
    {
        return createLoanCommandHandler.handle(command);
    }
}
