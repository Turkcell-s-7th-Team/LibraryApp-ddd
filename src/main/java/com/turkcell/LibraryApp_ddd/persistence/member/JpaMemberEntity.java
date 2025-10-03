package com.turkcell.LibraryApp_ddd.persistence.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table
public class JpaMemberEntity {

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "surname", nullable = false, length = 100)
    private String surname;

    @Column(name = "email", nullable = false, length = 150)
    @Email(message = "Geçerli bir email giriniz")
    @NotBlank
    private String email;

    @NotBlank
    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "address", length = 255)
    private String address;


    @Column(name = "membership_level", nullable = true, length = 20)
    private String membershipLevel;

    @Column(name = "membership_date")
    private LocalDate membershipDate;

    //TODO:. loan bekleniyor
   /* @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Loan> loans = new ArrayList<>();*/

    public UUID id() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String surname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public @Email(message = "Geçerli bir email giriniz") @NotBlank String email() {
        return email;
    }

    public void setEmail(@Email(message = "Geçerli bir email giriniz") @NotBlank String email) {
        this.email = email;
    }

    public @NotBlank String phone() {
        return phone;
    }

    public void setPhone(@NotBlank String phone) {
        this.phone = phone;
    }

    public String address() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String membershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(String membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    public LocalDate membershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(LocalDate membershipDate) {
        this.membershipDate = membershipDate;
    }
}
