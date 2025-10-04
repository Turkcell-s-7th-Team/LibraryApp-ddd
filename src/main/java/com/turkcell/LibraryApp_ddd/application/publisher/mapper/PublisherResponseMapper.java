package com.turkcell.LibraryApp_ddd.application.publisher.mapper;

import com.turkcell.LibraryApp_ddd.application.publisher.dto.PublisherResponse;
import com.turkcell.LibraryApp_ddd.domain.member.model.Address;
import com.turkcell.LibraryApp_ddd.domain.publisher.model.Publisher;

public class PublisherResponseMapper {
    private String name;
    private Address address;

    public PublisherResponse toResponse(Publisher publisher) {
        return new PublisherResponse(publisher.name(), publisher.address().toString());
    }
}
