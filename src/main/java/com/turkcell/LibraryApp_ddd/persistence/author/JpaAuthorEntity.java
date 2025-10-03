package com.turkcell.LibraryApp_ddd.persistence.author;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "authors")
public class JpaAuthorEntity {

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "surname", nullable = false, length = 255)
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    public UUID id() {
        return id;
    }

    public JpaAuthorEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public String name() {
        return name;
    }

    public JpaAuthorEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String surname() {
        return surname;
    }

    public JpaAuthorEntity setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String email() {
        return email;
    }

    public JpaAuthorEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String phoneNumber() {
        return phoneNumber;
    }

    public JpaAuthorEntity setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
