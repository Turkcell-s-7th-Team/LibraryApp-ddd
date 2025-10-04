package com.turkcell.LibraryApp_ddd.persistence.category;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "categories")
public class JpaCategoryEntity {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", nullable = false, length = 255)
    private String description;


    public JpaCategoryEntity() {
    }

    public JpaCategoryEntity(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "JpaCategoryEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
