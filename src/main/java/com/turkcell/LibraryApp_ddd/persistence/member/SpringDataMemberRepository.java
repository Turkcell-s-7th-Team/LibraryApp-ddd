package com.turkcell.LibraryApp_ddd.persistence.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataMemberRepository extends JpaRepository <JpaMemberEntity, UUID> {
}
