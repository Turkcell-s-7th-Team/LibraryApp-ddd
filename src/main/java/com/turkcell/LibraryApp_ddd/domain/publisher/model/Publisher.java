package com.turkcell.LibraryApp_ddd.domain.publisher.model;

public class Publisher {

    private final PublisherId id;
    private String name;
    private Address address;

    private Publisher(PublisherId id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public static Publisher create(String name, String address) {
        return new Publisher(PublisherId.generate(), name, new Address(address));
    }

    public static Publisher rehydrate(PublisherId id, String name, Address address)
    {
        return new Publisher(id, name, address);
    }

    public PublisherId id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Address address() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
