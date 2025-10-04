package com.turkcell.LibraryApp_ddd.application.staff.mapper;

import com.turkcell.LibraryApp_ddd.application.staff.dto.StaffResponse;
import com.turkcell.LibraryApp_ddd.domain.staff.model.Staff;
import org.springframework.stereotype.Component;

@Component
public class StaffResponseMapper {

    public StaffResponse toResponse(Staff staff) {
        return new StaffResponse(
                staff.name(),
                staff.surname(),
                staff.phone().toString()
        );
    }
}
