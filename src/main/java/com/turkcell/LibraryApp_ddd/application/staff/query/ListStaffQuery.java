package com.turkcell.LibraryApp_ddd.application.staff.query;

import com.turkcell.LibraryApp_ddd.application.staff.dto.StaffResponse;
import com.turkcell.LibraryApp_ddd.core.cqrs.Query;
import jakarta.validation.constraints.Min;

import java.util.List;

public record ListStaffQuery(
        @Min(0) Integer pageIndex,
        @Min(1) Integer pageSize
) implements Query<List<StaffResponse>> {
}
