package com.turkcell.LibraryApp_ddd.application.publisher.query;

import com.turkcell.LibraryApp_ddd.application.publisher.dto.PublisherResponse;
import com.turkcell.LibraryApp_ddd.application.publisher.mapper.PublisherResponseMapper;
import com.turkcell.LibraryApp_ddd.core.cqrs.QueryHandler;
import com.turkcell.LibraryApp_ddd.domain.publisher.repository.PublisherRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListPublishersQueryHandler implements QueryHandler<ListPublishersQuery, List<PublisherResponse>> {

    private final PublisherRepository publisherRepository;
    private final PublisherResponseMapper publisherResponseMapper;

    public ListPublishersQueryHandler(PublisherRepository publisherRepository, PublisherResponseMapper publisherResponseMapper) {
        this.publisherRepository = publisherRepository;
        this.publisherResponseMapper = publisherResponseMapper;
    }


    @Override
    public List<PublisherResponse> handle(ListPublishersQuery query) {
        return publisherRepository.findAllPaged(query.pageIndex(), query.pageSize()).stream().map(publisherResponseMapper::toResponse).toList();
    }
}
