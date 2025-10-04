package com.turkcell.LibraryApp_ddd.application.reservation.command;

import com.turkcell.LibraryApp_ddd.application.reservation.dto.CreatedReservationResponse;
import com.turkcell.LibraryApp_ddd.application.reservation.mapper.CreateReservationMapper;
import com.turkcell.LibraryApp_ddd.core.cqrs.CommandHandler;
import com.turkcell.LibraryApp_ddd.domain.reservation.model.Reservation;
import com.turkcell.LibraryApp_ddd.domain.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateReservationCommandHandler implements CommandHandler<CreateReservationCommand, CreatedReservationResponse> {

    private final ReservationRepository reservationRepository;
    private final CreateReservationMapper createReservationMapper;

    public CreateReservationCommandHandler(ReservationRepository reservationRepository, CreateReservationMapper createReservationMapper) {
        this.reservationRepository = reservationRepository;
        this.createReservationMapper = createReservationMapper;
    }

    @Override
    public CreatedReservationResponse handle(CreateReservationCommand command) {
        Reservation reservation = createReservationMapper.toDomain(command);
        reservation = reservationRepository.save(reservation);
        return createReservationMapper.toResponse(reservation);
    }
}
