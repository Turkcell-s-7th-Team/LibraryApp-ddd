package com.turkcell.LibraryApp_ddd.persistence.member;

import com.turkcell.LibraryApp_ddd.domain.member.model.*;
import org.springframework.stereotype.Component;

@Component
public class MemberEntityMapper {

    public JpaMemberEntity toEntity(Member member) {
        JpaMemberEntity jpaMemberEntity = new JpaMemberEntity();
        jpaMemberEntity.setId(member.id().value());
        jpaMemberEntity.setName(member.name());
        jpaMemberEntity.setEmail(member.email().toString());
        jpaMemberEntity.setPhone(member.phone().toString());
        jpaMemberEntity.setAddress(member.address().toString());
        jpaMemberEntity.setSurname(member.surname());
        jpaMemberEntity.setMembershipDate(member.membershipDate());
        jpaMemberEntity.setMembershipLevel(member.membershipLevel().toString());
        return jpaMemberEntity;
    }

    public Member toDomain(JpaMemberEntity entity) {
        return Member.rehydrate(new MemberId(entity.id()), entity.name(), entity.surname(), new Email(entity.email()), new Phone(entity.phone()), new Address(entity.address()), entity.membershipDate(),new MembershipLevel(entity.membershipLevel()));
    }
}
