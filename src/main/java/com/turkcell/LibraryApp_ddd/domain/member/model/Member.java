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

    //TODO:: MembershipLevel enum'ı ve Loan oluşturulduktan sonra alanları aç!
    /*private MembershipLevel membershipLevel;
    private final List<Loan> loans = new ArrayList<>();
*/

    private Member(MemberId id, String name, String surname, Email email, Phone phone, Address address, LocalDate membershipDate) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        ;
        this.surname = Objects.requireNonNull(surname);
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.membershipDate = membershipDate != null ? membershipDate : LocalDate.now();
    }

    public static Member create(String name, String surname, String email, String phone, String address, LocalDate membershipDate) {
        return new Member(
                MemberId.generate(),
                name,
                surname,
                new Email(email),
                new Phone(phone),
                new Address(address),
                membershipDate
        );
    }

    public static Member rehydrate(MemberId id, String name, String surname, Email email, Phone phone, Address address, LocalDate membershipDate) {
        return new Member(id, name, surname, email, phone, address, membershipDate);
    }

    public void rename(String newName) {
        validateName(newName);
        this.name = newName;
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

    public LocalDate membershipDate() {
        return membershipDate;
    }

    private static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }

    private static void validateSurname(String surname) {
        if (surname == null || surname.trim().isEmpty()) {
            throw new IllegalArgumentException("Surname cannot be null or empty");
        }
    }
}

