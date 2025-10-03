package com.turkcell.LibraryApp_ddd.domain.member.model;

import java.time.LocalDate;
import java.util.Objects;

public class Member {

    private final MemberId id;
    private String name;
    private String surname;
    private Email email;
    private Phone phone;
    private Address address;
    private LocalDate membershipDate;
    private MembershipLevel membershipLevel;

    //TODO:: LOAN hazır olunca
    //   private final List<Loan> loans = new ArrayList<>();


    private Member(MemberId id, String name, String surname, Email email, Phone phone, Address address, LocalDate membershipDate, MembershipLevel membershipLevel) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.membershipDate = membershipDate;
        this.membershipLevel = membershipLevel;
    }

    public static Member create(String name, String surname, String email, String phone, String address, LocalDate membershipDate, MembershipLevel membershipLevel) {
        return new Member(MemberId.generate(), name, surname, new Email(email), new Phone(phone), new Address(address), membershipDate,  membershipLevel);
    }

    public static Member rehydrate(MemberId id, String name, String surname, Email email, Phone phone, Address address, LocalDate membershipDate, MembershipLevel membershipLevel) {
        return new Member(id, name, surname, email, phone, address, membershipDate, membershipLevel);
    }

    public Email email() {
        return email;
    }

    public Address address() {
        return address;
    }

    public Phone phone() {
        return phone;
    }

    public MemberId id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String surname() {
        return surname;
    }

    public MembershipLevel membershipLevel() {
        return membershipLevel;
    }

    public LocalDate membershipDate() {
        return membershipDate;
    }

}

