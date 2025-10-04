package com.turkcell.LibraryApp_ddd.persistence.staff;

import com.turkcell.LibraryApp_ddd.domain.staff.model.*;
import org.springframework.stereotype.Component;

@Component
public class StaffEntityMapper {

    public JpaStaffEntity toEntity(Staff staff) {
        JpaStaffEntity jpaStaffEntity = new JpaStaffEntity();
        jpaStaffEntity.setId(staff.id().value());
        jpaStaffEntity.setName(staff.name());
        jpaStaffEntity.setSurname(staff.surname());
        jpaStaffEntity.setPhone(staff.phone().toString());
        return jpaStaffEntity;
    }

    public Staff toDomain(JpaStaffEntity entity) {
        return Staff.rehydrate(
                new StaffId(entity.id()),
                entity.name(),
                entity.surname(),
                new Phone(entity.phone())
        );
    }
}
