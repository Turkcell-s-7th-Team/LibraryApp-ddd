package com.turkcell.LibraryApp_ddd.persistence.publisher;


import com.turkcell.LibraryApp_ddd.domain.publisher.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataPublisherRepository extends JpaRepository<JpaPublisherEntity, UUID> {
}
