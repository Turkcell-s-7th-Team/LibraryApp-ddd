package com.turkcell.LibraryApp_ddd.application.member.command;

import com.turkcell.LibraryApp_ddd.application.member.dto.CreatedMemberResponse;
import com.turkcell.LibraryApp_ddd.application.member.mapper.CreateMemberMapper;
import com.turkcell.LibraryApp_ddd.core.cqrs.CommandHandler;
import com.turkcell.LibraryApp_ddd.domain.member.model.Member;
import com.turkcell.LibraryApp_ddd.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateMemberCommandHandler implements CommandHandler<CreateMemberCommand, CreatedMemberResponse> {

    private final MemberRepository memberRepository;
    private final CreateMemberMapper createMemberMapper;

    public CreateMemberCommandHandler(MemberRepository memberRepository, CreateMemberMapper createMemberMapper) {
        this.memberRepository = memberRepository;
        this.createMemberMapper = createMemberMapper;
    }

    @Override
    public CreatedMemberResponse handle(CreateMemberCommand command) {
        Member member = createMemberMapper.toDomain(command);
        member = memberRepository.save(member);
        return createMemberMapper.toResponse(member);
    }
}
