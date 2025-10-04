package com.turkcell.LibraryApp_ddd.domain.reservation.repository;

import com.turkcell.LibraryApp_ddd.domain.reservation.model.Reservation;
import com.turkcell.LibraryApp_ddd.domain.reservation.model.ReservationId;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository {

    Reservation save(Reservation reservation);

    Optional<Reservation> getReservationById(ReservationId id);

    List<Reservation> getAllReservations();

    List<Reservation> findAllPaged(Integer pageIndex, Integer pageSize);

    void deleteReservationById(ReservationId id);
}
