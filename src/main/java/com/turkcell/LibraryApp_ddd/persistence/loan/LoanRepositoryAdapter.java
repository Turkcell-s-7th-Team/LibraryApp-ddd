package com.turkcell.LibraryApp_ddd.persistence.loan;

import com.turkcell.LibraryApp_ddd.domain.loan.model.Loan;
import com.turkcell.LibraryApp_ddd.domain.loan.model.LoanId;
import com.turkcell.LibraryApp_ddd.domain.loan.repository.LoanRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LoanRepositoryAdapter implements LoanRepository {
    private final SpringDataLoanRepository repository;
    private final LoanEntityMapper loanEntityMapper;

    public LoanRepositoryAdapter(SpringDataLoanRepository repository, LoanEntityMapper loanEntityMapper) {
        this.repository = repository;
        this.loanEntityMapper = loanEntityMapper;
    }

    @Override
    public Loan save(Loan loan) {
        JpaLoanEntity entity = loanEntityMapper.toEntity(loan);
        entity = repository.save(entity);
        return loanEntityMapper.toDomain(entity);
    }

    @Override
    public Optional<Loan> findById(LoanId loanId) {
        return repository
                .findById(loanId.value())
                .map(loanEntityMapper::toDomain);
    }

    @Override
    public List<Loan> findAllPaged(Integer pageIndex, Integer pageSize) {
        return repository
                .findAll(PageRequest.of(pageIndex, pageSize))
                .stream().map(loanEntityMapper::toDomain)
                .toList();
    }

    @Override
    public void delete(LoanId loanId) {
        repository.deleteById(loanId.value());

    }
}
