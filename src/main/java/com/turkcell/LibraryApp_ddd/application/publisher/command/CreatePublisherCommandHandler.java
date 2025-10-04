package com.turkcell.LibraryApp_ddd.application.publisher.command;

import com.turkcell.LibraryApp_ddd.application.publisher.dto.CreatedPublisherResponse;
import com.turkcell.LibraryApp_ddd.application.publisher.mapper.CreatePublisherMapper;
import com.turkcell.LibraryApp_ddd.core.cqrs.CommandHandler;
import com.turkcell.LibraryApp_ddd.domain.publisher.model.Publisher;
import com.turkcell.LibraryApp_ddd.domain.publisher.repository.PublisherRepository;

public class CreatePublisherCommandHandler implements CommandHandler<CreatePublisherCommand,CreatedPublisherResponse> {

    private final PublisherRepository publisherRepository;
    private final CreatePublisherMapper createPublisherMapper;

    public CreatePublisherCommandHandler(PublisherRepository publisherRepository, CreatePublisherMapper createPublisherMapper) {
        this.publisherRepository = publisherRepository;
        this.createPublisherMapper = createPublisherMapper;
    }

    @Override
    public CreatedPublisherResponse handle(CreatePublisherCommand command) {
    Publisher publisher = createPublisherMapper.toDomain(command);
    publisher = publisherRepository.save(publisher);
    return createPublisherMapper.toResponse(publisher);
    }
}
