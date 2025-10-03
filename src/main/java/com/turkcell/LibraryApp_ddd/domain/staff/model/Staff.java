package com.turkcell.LibraryApp_ddd.domain.staff.model;

public class Staff {

    private final StaffId id;
    private String name;
    private String surname;
    private Phone phone;

    private Staff(StaffId id, String name, String surname, Phone phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public static Staff create(String name, String surname, String phone) {
        return new Staff(StaffId.generate(), name, surname, new Phone(phone));
    }

    public static Staff rehydrate(StaffId id, String name, String surname, Phone phone) {
        return new Staff(id, name, surname, phone);
    }


    public StaffId id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String surname() {
        return surname;
    }

    public Phone phone() {
        return phone;
    }
}
