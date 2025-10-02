package com.turkcell.LibraryApp_ddd.persistence.author;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataAuthorRepository extends JpaRepository<JpaAuthorEntity, UUID> {
}
