package com.turkcell.LibraryApp_ddd.persistence.staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataStaffRepository extends JpaRepository<JpaStaffEntity, UUID> {
}
