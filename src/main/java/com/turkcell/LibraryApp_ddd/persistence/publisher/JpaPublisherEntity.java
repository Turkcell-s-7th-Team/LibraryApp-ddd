package com.turkcell.LibraryApp_ddd.persistence.publisher;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

@Entity
@Table(name = "publishers")
public class JpaPublisherEntity {

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "address", length = 255)
    private String address;


    public UUID id() {
        return id;
    }

    public String address() {
        return address;
    }

    public  String name() {
        return name;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public  @NotBlank void setName(String name) {
        this.name = name;
    }

    public @NotBlank void setAddress(String address) {
        this.address = address;
    }
}
