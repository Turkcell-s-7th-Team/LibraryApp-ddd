package com.turkcell.LibraryApp_ddd.persistence.staff;

import com.turkcell.LibraryApp_ddd.domain.staff.model.Staff;
import com.turkcell.LibraryApp_ddd.domain.staff.model.StaffId;
import com.turkcell.LibraryApp_ddd.domain.staff.repository.StaffRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StaffRepositoryAdapter implements StaffRepository {

    private final SpringDataStaffRepository springDataStaffRepository;
    private final StaffEntityMapper staffEntityMapper;

    public StaffRepositoryAdapter(SpringDataStaffRepository springDataStaffRepository, StaffEntityMapper staffEntityMapper) {
        this.springDataStaffRepository = springDataStaffRepository;
        this.staffEntityMapper = staffEntityMapper;
    }

    @Override
    public Staff save(Staff staff) {
        var entity = staffEntityMapper.toEntity(staff);
        entity = springDataStaffRepository.save(entity);
        return staffEntityMapper.toDomain(entity);
    }

    @Override
    public Optional<Staff> getStaffById(StaffId id) {
        return springDataStaffRepository.findById(id.value()).map(staffEntityMapper::toDomain);
    }

    @Override
    public List<Staff> getAllStaff() {
        return springDataStaffRepository.findAll().stream().map(staffEntityMapper::toDomain).toList();
    }

    @Override
    public List<Staff> findAllPaged(Integer pageIndex, Integer pageSize) {
        return springDataStaffRepository.findAll(PageRequest.of(pageIndex, pageSize))
                .stream().map(staffEntityMapper::toDomain).toList();
    }

    @Override
    public void deleteStaffById(StaffId id) {
        springDataStaffRepository.deleteById(id.value());
    }
}
