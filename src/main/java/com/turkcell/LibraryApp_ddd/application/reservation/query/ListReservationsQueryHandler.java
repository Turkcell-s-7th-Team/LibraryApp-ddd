package com.turkcell.LibraryApp_ddd.application.reservation.query;

import com.turkcell.LibraryApp_ddd.application.reservation.dto.ReservationResponse;
import com.turkcell.LibraryApp_ddd.application.reservation.mapper.ReservationResponseMapper;
import com.turkcell.LibraryApp_ddd.core.cqrs.QueryHandler;
import com.turkcell.LibraryApp_ddd.domain.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListReservationsQueryHandler implements QueryHandler<ListReservationsQuery, List<ReservationResponse>> {

    private final ReservationRepository reservationRepository;
    private final ReservationResponseMapper reservationResponseMapper;

    public ListReservationsQueryHandler(ReservationRepository reservationRepository, ReservationResponseMapper reservationResponseMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationResponseMapper = reservationResponseMapper;
    }

    @Override
    public List<ReservationResponse> handle(ListReservationsQuery query) {
        return reservationRepository.findAllPaged(query.pageIndex(), query.pageSize())
                .stream()
                .map(reservationResponseMapper::toResponse)
                .toList();
    }
}
