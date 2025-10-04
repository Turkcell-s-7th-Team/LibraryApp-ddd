package com.turkcell.LibraryApp_ddd.application.member.query;

import com.turkcell.LibraryApp_ddd.application.member.dto.MemberResponse;
import com.turkcell.LibraryApp_ddd.application.member.mapper.MemberResponseMapper;
import com.turkcell.LibraryApp_ddd.core.cqrs.QueryHandler;
import com.turkcell.LibraryApp_ddd.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListMembersQueryHandler implements QueryHandler<ListMembersQuery, List<MemberResponse>> {

    private final MemberRepository memberRepository;
    private final MemberResponseMapper memberResponseMapper;

    public ListMembersQueryHandler(MemberRepository memberRepository, MemberResponseMapper memberResponseMapper) {
        this.memberRepository = memberRepository;
        this.memberResponseMapper = memberResponseMapper;
    }

    @Override
    public List<MemberResponse> handle(ListMembersQuery query) {
        return memberRepository.findAllPaged(query.pageIndex(), query.pageSize()).stream().map(memberResponseMapper::toResponse).toList();
    }
}
