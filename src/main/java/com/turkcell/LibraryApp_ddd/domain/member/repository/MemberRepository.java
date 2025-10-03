package com.turkcell.LibraryApp_ddd.domain.member.repository;

import com.turkcell.LibraryApp_ddd.domain.member.model.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member> getMemberById(Integer id);

    List<Member> getAllMembers();

    void deleteMemberById(Integer id);

}
