package com.turkcell.LibraryApp_ddd.application.member.mapper;

import com.turkcell.LibraryApp_ddd.application.member.command.CreateMemberCommand;
import com.turkcell.LibraryApp_ddd.application.member.dto.CreatedMemberResponse;
import com.turkcell.LibraryApp_ddd.domain.member.model.Member;
import com.turkcell.LibraryApp_ddd.domain.member.model.MembershipLevel;
import org.springframework.stereotype.Component;

@Component
public class CreateMemberMapper {

    public Member toDomain(CreateMemberCommand command) {
        return Member.create(command.name(), command.surname(), command.email(), command.phone(), command.address(), command.membershipDate(), new MembershipLevel(command.membershipLevel()));
    }

    public CreatedMemberResponse toResponse(Member member) {
        return new CreatedMemberResponse(member.id().value(), member.name(), member.surname(), member.email().toString(), member.phone().toString(), member.address().toString(), member.membershipDate(), member.membershipLevel().toString());

    }
}
