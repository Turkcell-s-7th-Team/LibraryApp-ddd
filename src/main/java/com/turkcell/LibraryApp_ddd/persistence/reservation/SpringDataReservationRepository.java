package com.turkcell.LibraryApp_ddd.persistence.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataReservationRepository extends JpaRepository<JpaReservationEntity, UUID> {
}
