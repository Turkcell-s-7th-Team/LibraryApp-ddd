package com.turkcell.LibraryApp_ddd.domain.staff.repository;

import com.turkcell.LibraryApp_ddd.domain.staff.model.Staff;
import com.turkcell.LibraryApp_ddd.domain.staff.model.StaffId;

import java.util.List;
import java.util.Optional;

public interface StaffRepository {

    Staff save(Staff staff);

    Optional<Staff> getStaffById(StaffId id);

    List<Staff> getAllStaff();

    List<Staff> findAllPaged(Integer pageIndex, Integer pageSize);

    void deleteStaffById(StaffId id);

}
