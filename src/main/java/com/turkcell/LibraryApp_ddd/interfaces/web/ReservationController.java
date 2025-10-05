package com.turkcell.LibraryApp_ddd.interfaces.web;

import com.turkcell.LibraryApp_ddd.application.reservation.command.CreateReservationCommand;
import com.turkcell.LibraryApp_ddd.application.reservation.dto.CreatedReservationResponse;
import com.turkcell.LibraryApp_ddd.application.reservation.dto.ReservationResponse;
import com.turkcell.LibraryApp_ddd.application.reservation.query.ListReservationsQuery;
import com.turkcell.LibraryApp_ddd.core.cqrs.CommandHandler;
import com.turkcell.LibraryApp_ddd.core.cqrs.QueryHandler;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@Validated
public class ReservationController {

    private final QueryHandler<ListReservationsQuery, List<ReservationResponse>> listReservationsQueryHandler;
    private final CommandHandler<CreateReservationCommand, CreatedReservationResponse> createReservationCommandHandler;

    public ReservationController(QueryHandler<ListReservationsQuery, List<ReservationResponse>> listReservationsQueryHandler,
                                 CommandHandler<CreateReservationCommand, CreatedReservationResponse> createReservationCommandHandler) {
        this.listReservationsQueryHandler = listReservationsQueryHandler;
        this.createReservationCommandHandler = createReservationCommandHandler;
    }

    @GetMapping
    public List<ReservationResponse> getReservations(
            @RequestParam(defaultValue = "0") Integer pageIndex,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        ListReservationsQuery query = new ListReservationsQuery(pageIndex, pageSize);
        return listReservationsQueryHandler.handle(query);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedReservationResponse createReservation(
            @Valid @RequestBody CreateReservationCommand command) {
        return createReservationCommandHandler.handle(command);
    }

}
