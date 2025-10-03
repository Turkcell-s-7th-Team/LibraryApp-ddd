package com.turkcell.LibraryApp_ddd.application.staff.command;

import com.turkcell.LibraryApp_ddd.application.staff.dto.CreatedStaffResponse;
import com.turkcell.LibraryApp_ddd.application.staff.mapper.CreateStaffMapper;
import com.turkcell.LibraryApp_ddd.core.cqrs.CommandHandler;
import com.turkcell.LibraryApp_ddd.domain.staff.model.Staff;
import com.turkcell.LibraryApp_ddd.domain.staff.repository.StaffRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateStaffCommandHandler implements CommandHandler<CreateStaffCommand, CreatedStaffResponse> {

    private final StaffRepository staffRepository;
    private final CreateStaffMapper createStaffMapper;

    public CreateStaffCommandHandler(StaffRepository staffRepository, CreateStaffMapper createStaffMapper) {
        this.staffRepository = staffRepository;
        this.createStaffMapper = createStaffMapper;
    }

    @Override
    public CreatedStaffResponse handle(CreateStaffCommand command) {
        Staff staff = createStaffMapper.toDomain(command);
        staff = staffRepository.save(staff);
        return createStaffMapper.toResponse(staff);
    }
}
