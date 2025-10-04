package com.turkcell.LibraryApp_ddd.domain.member.repository;

import com.turkcell.LibraryApp_ddd.domain.author.model.Author;
import com.turkcell.LibraryApp_ddd.domain.member.model.Member;
import com.turkcell.LibraryApp_ddd.domain.member.model.MemberId;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member> getMemberById(MemberId id);

    List<Member> getAllMembers();

    List<Member> findAllPaged(Integer pageIndex, Integer pageSize);

    void deleteMemberById(MemberId id);

}
