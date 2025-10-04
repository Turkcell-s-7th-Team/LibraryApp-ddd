package com.turkcell.LibraryApp_ddd.persistence.category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataCategoryRepository extends JpaRepository<JpaCategoryEntity, UUID> { }
