package com.turkcell.LibraryApp_ddd.persistence.publisher;

import com.turkcell.LibraryApp_ddd.domain.publisher.model.Publisher;
import com.turkcell.LibraryApp_ddd.domain.publisher.model.PublisherId;
import com.turkcell.LibraryApp_ddd.domain.publisher.repository.PublisherRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PublisherRepositoryAdapter implements PublisherRepository {


    private final SpringDataPublisherRepository springDataPublisherRepository;
    private final PublisherEntityMapper publisherEntityMapper;

    public PublisherRepositoryAdapter(SpringDataPublisherRepository springDataPublisherRepository, PublisherEntityMapper publisherEntityMapper) {
        this.springDataPublisherRepository = springDataPublisherRepository;
        this.publisherEntityMapper = publisherEntityMapper;
    }


    @Override
    public Publisher save(Publisher publisher) {
        JpaPublisherEntity entity = publisherEntityMapper.toEntity(publisher);
        entity = springDataPublisherRepository.save(entity);
        return publisherEntityMapper.toDomain(entity);
    }

    @Override
    public Optional<Publisher> findById(PublisherId id) {
        return springDataPublisherRepository.findById(id.value()).map(publisherEntityMapper::toDomain);
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return springDataPublisherRepository.findAll().stream().map(publisherEntityMapper::toDomain).toList();
    }

    @Override
    public List<Publisher> findAllPaged(Integer pageIndex, Integer pageSize) {
        return springDataPublisherRepository.findAll(PageRequest.of(pageIndex,pageSize)).stream().map(publisherEntityMapper::toDomain).toList();
    }

    @Override
    public void deleteMemberById(PublisherId id) {
    springDataPublisherRepository.deleteById(id.value());
    }
}
