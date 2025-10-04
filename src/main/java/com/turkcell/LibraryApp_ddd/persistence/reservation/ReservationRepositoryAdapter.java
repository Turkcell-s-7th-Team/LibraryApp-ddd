package com.turkcell.LibraryApp_ddd.persistence.reservation;

import com.turkcell.LibraryApp_ddd.domain.reservation.model.Reservation;
import com.turkcell.LibraryApp_ddd.domain.reservation.model.ReservationId;
import com.turkcell.LibraryApp_ddd.domain.reservation.repository.ReservationRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepositoryAdapter implements ReservationRepository {

    private final SpringDataReservationRepository springDataReservationRepository;
    private final ReservationEntityMapper reservationEntityMapper;

    public ReservationRepositoryAdapter(SpringDataReservationRepository springDataReservationRepository,
                                        ReservationEntityMapper reservationEntityMapper) {
        this.springDataReservationRepository = springDataReservationRepository;
        this.reservationEntityMapper = reservationEntityMapper;
    }

    @Override
    public Reservation save(Reservation reservation) {
        JpaReservationEntity entity = reservationEntityMapper.toEntity(reservation);
        entity = springDataReservationRepository.save(entity);
        return reservationEntityMapper.toDomain(entity);
    }

    @Override
    public Optional<Reservation> getReservationById(ReservationId id) {
        return springDataReservationRepository.findById(id.value())
                .map(reservationEntityMapper::toDomain);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return springDataReservationRepository.findAll().stream().map(reservationEntityMapper::toDomain).toList();
    }

    @Override
    public List<Reservation> findAllPaged(Integer pageIndex, Integer pageSize) {
        return springDataReservationRepository.findAll(PageRequest.of(pageIndex, pageSize))
                .stream()
                .map(reservationEntityMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteReservationById(ReservationId id) {
        springDataReservationRepository.deleteById(id.value());
    }
}
