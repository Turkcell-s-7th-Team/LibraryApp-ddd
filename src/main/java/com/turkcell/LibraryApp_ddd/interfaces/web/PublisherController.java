package com.turkcell.LibraryApp_ddd.interfaces.web;

import com.turkcell.LibraryApp_ddd.application.publisher.command.CreatePublisherCommand;
import com.turkcell.LibraryApp_ddd.application.publisher.dto.CreatedPublisherResponse;
import com.turkcell.LibraryApp_ddd.application.publisher.dto.PublisherResponse;
import com.turkcell.LibraryApp_ddd.application.publisher.query.ListPublishersQuery;
import com.turkcell.LibraryApp_ddd.core.cqrs.CommandHandler;
import com.turkcell.LibraryApp_ddd.core.cqrs.QueryHandler;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/publisher")
public class PublisherController {
    private final QueryHandler<ListPublishersQuery, List<PublisherResponse>> listPublishersQueryHandler;
    private final CommandHandler<CreatePublisherCommand, CreatedPublisherResponse> createddPublisherCommandHandler;

    public PublisherController(QueryHandler<ListPublishersQuery, List<PublisherResponse>> listPublishersQueryHandler, CommandHandler<CreatePublisherCommand, CreatedPublisherResponse> createddPublisherCommandHandler) {
        this.listPublishersQueryHandler = listPublishersQueryHandler;
        this.createddPublisherCommandHandler = createddPublisherCommandHandler;
    }

    @GetMapping
    public List<PublisherResponse> getPublishers(@Valid ListPublishersQuery query) {
        return listPublishersQueryHandler.handle(query);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedPublisherResponse createPublisher(@Valid CreatePublisherCommand command) {
        return createddPublisherCommandHandler.handle(command);
    }
}
