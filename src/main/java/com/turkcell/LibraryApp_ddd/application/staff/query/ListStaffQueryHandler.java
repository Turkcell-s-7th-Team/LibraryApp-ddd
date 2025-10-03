package com.turkcell.LibraryApp_ddd.application.staff.query;

import com.turkcell.LibraryApp_ddd.application.staff.dto.StaffResponse;
import com.turkcell.LibraryApp_ddd.application.staff.mapper.StaffResponseMapper;
import com.turkcell.LibraryApp_ddd.core.cqrs.QueryHandler;
import com.turkcell.LibraryApp_ddd.domain.staff.repository.StaffRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListStaffQueryHandler implements QueryHandler<ListStaffQuery, List<StaffResponse>> {

    private final StaffRepository staffRepository;
    private final StaffResponseMapper staffResponseMapper;

    public ListStaffQueryHandler(StaffRepository staffRepository, StaffResponseMapper staffResponseMapper) {
        this.staffRepository = staffRepository;
        this.staffResponseMapper = staffResponseMapper;
    }

    @Override
    public List<StaffResponse> handle(ListStaffQuery query) {
        return staffRepository
                .findAllPaged(query.pageIndex(), query.pageSize())
                .stream()
                .map(staffResponseMapper::toResponse)
                .toList();
    }
}
