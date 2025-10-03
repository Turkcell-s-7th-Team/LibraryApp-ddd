package com.turkcell.LibraryApp_ddd.interfaces.web;

import com.turkcell.LibraryApp_ddd.application.staff.command.CreateStaffCommand;
import com.turkcell.LibraryApp_ddd.application.staff.dto.CreatedStaffResponse;
import com.turkcell.LibraryApp_ddd.application.staff.dto.StaffResponse;
import com.turkcell.LibraryApp_ddd.application.staff.query.ListStaffQuery;
import com.turkcell.LibraryApp_ddd.core.cqrs.CommandHandler;
import com.turkcell.LibraryApp_ddd.core.cqrs.QueryHandler;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
@Validated
public class StaffController {

    private final QueryHandler<ListStaffQuery, List<StaffResponse>> listStaffQueryHandler;
    private final CommandHandler<CreateStaffCommand, CreatedStaffResponse> createStaffCommandHandler;

    public StaffController(QueryHandler<ListStaffQuery, List<StaffResponse>> listStaffQueryHandler,
                           CommandHandler<CreateStaffCommand, CreatedStaffResponse> createStaffCommandHandler) {
        this.listStaffQueryHandler = listStaffQueryHandler;
        this.createStaffCommandHandler = createStaffCommandHandler;
    }

    @GetMapping
    public List<StaffResponse> getStaff(@Valid ListStaffQuery query) {
        return listStaffQueryHandler.handle(query);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedStaffResponse createStaff(@Valid CreateStaffCommand command) {
        return createStaffCommandHandler.handle(command);
    }
}
