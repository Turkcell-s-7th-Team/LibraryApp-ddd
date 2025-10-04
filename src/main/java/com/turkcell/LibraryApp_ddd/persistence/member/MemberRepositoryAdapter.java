package com.turkcell.LibraryApp_ddd.persistence.member;

import com.turkcell.LibraryApp_ddd.domain.author.model.Author;
import com.turkcell.LibraryApp_ddd.domain.member.model.Member;
import com.turkcell.LibraryApp_ddd.domain.member.model.MemberId;
import com.turkcell.LibraryApp_ddd.domain.member.repository.MemberRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepositoryAdapter implements MemberRepository {

    private final SpringDataMemberRepository springDataMemberRepository;
    private final MemberEntityMapper memberEntityMapper;

    public MemberRepositoryAdapter(SpringDataMemberRepository springDataMemberRepository, MemberEntityMapper memberEntityMapper) {
        this.springDataMemberRepository = springDataMemberRepository;
        this.memberEntityMapper = memberEntityMapper;
    }

    @Override
    public Member save(Member member) {
        JpaMemberEntity entity = memberEntityMapper.toEntity(member);
        entity = springDataMemberRepository.save(entity);
        return memberEntityMapper.toDomain(entity);
    }

    @Override
    public Optional<Member> getMemberById(MemberId id) {
        return springDataMemberRepository.findById(id.value()).map(memberEntityMapper::toDomain);
    }

    @Override
    public List<Member> getAllMembers() {
        return springDataMemberRepository.findAll().stream().map(memberEntityMapper::toDomain).toList();
    }

    @Override
    public List<Member> findAllPaged(Integer pageIndex, Integer pageSize) {
        return springDataMemberRepository.findAll(PageRequest.of(pageIndex, pageSize)).stream().map(memberEntityMapper::toDomain).toList();
    }

    @Override
    public void deleteMemberById(MemberId id) {
        springDataMemberRepository.deleteById(id.value());
    }
}
