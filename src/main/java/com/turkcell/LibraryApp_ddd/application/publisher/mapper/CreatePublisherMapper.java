package com.turkcell.LibraryApp_ddd.application.publisher.mapper;

import com.turkcell.LibraryApp_ddd.application.publisher.command.CreatePublisherCommand;
import com.turkcell.LibraryApp_ddd.application.publisher.dto.CreatedPublisherResponse;
import com.turkcell.LibraryApp_ddd.domain.publisher.model.Publisher;
import org.springframework.stereotype.Component;

@Component
public class CreatePublisherMapper {

    public Publisher toDomain(CreatePublisherCommand command) {
        return Publisher.create(command.name(), command.address());
    }

    public CreatedPublisherResponse toResponse(Publisher publisher) {
        return new CreatedPublisherResponse(publisher.id().value(), publisher.name(), publisher.address().toString());
    }
}
