package com.turkcell.LibraryApp_ddd.application.member.mapper;

import com.turkcell.LibraryApp_ddd.application.member.dto.MemberResponse;
import com.turkcell.LibraryApp_ddd.domain.member.model.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberResponseMapper {
    public MemberResponse toResponse(Member member) {
        return new MemberResponse(
                member.name(),
                member.surname(),
                member.email().toString(),
                member.phone().toString(),
                member.address().toString(),
                member.membershipDate(),
                member.membershipLevel().toString()
        );

    }
}
