package com.turkcell.LibraryApp_ddd.application.reservation.query;

import com.turkcell.LibraryApp_ddd.application.reservation.dto.ReservationResponse;
import com.turkcell.LibraryApp_ddd.core.cqrs.Query;
import jakarta.validation.constraints.Min;

import java.util.List;

public record ListReservationsQuery(
        @Min(0) Integer pageIndex,
        @Min(1) Integer pageSize
) implements Query<List<ReservationResponse>> {
}
