package com.turkcell.LibraryApp_ddd.application.staff.mapper;

import com.turkcell.LibraryApp_ddd.application.staff.command.CreateStaffCommand;
import com.turkcell.LibraryApp_ddd.application.staff.dto.CreatedStaffResponse;
import com.turkcell.LibraryApp_ddd.domain.staff.model.Staff;
import org.springframework.stereotype.Component;

@Component
public class CreateStaffMapper {

    public Staff toDomain(CreateStaffCommand command) {
        return Staff.create(command.name(), command.surname(), command.phone());
    }

    public CreatedStaffResponse toResponse(Staff staff) {
        return new CreatedStaffResponse(
                staff.id().value(),
                staff.name(),
                staff.surname(),
                staff.phone().toString()
        );
    }
}
