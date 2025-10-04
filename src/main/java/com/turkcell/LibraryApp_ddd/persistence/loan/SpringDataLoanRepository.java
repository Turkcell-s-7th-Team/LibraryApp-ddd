package com.turkcell.LibraryApp_ddd.persistence.loan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataLoanRepository extends JpaRepository<JpaLoanEntity, UUID> {
}
