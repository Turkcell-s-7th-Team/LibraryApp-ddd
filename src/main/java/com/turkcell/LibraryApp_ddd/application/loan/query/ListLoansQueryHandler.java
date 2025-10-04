package com.turkcell.LibraryApp_ddd.application.loan.query;

import com.turkcell.LibraryApp_ddd.application.loan.dto.LoanResponse;
import com.turkcell.LibraryApp_ddd.application.loan.mapper.LoanResponseMapper;
import com.turkcell.LibraryApp_ddd.core.cqrs.QueryHandler;
import com.turkcell.LibraryApp_ddd.domain.loan.repository.LoanRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListLoansQueryHandler implements QueryHandler<ListLoansQuery, List<LoanResponse>> {

    private final LoanRepository loanRepository;
    private final LoanResponseMapper loanResponseMapper;

    public ListLoansQueryHandler(LoanRepository loanRepository, LoanResponseMapper loanResponseMapper) {
        this.loanRepository = loanRepository;
        this.loanResponseMapper = loanResponseMapper;
    }

    @Override
    public List<LoanResponse> handle(ListLoansQuery query) {
        return loanRepository
                .findAllPaged(query.pageIndex(), query.pageSize())
                .stream()
                .map(loanResponseMapper::toResponse)
                .toList();
    }
}
