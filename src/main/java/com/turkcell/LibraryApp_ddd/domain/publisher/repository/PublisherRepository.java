package com.turkcell.LibraryApp_ddd.domain.publisher.repository;

import com.turkcell.LibraryApp_ddd.domain.publisher.model.Publisher;
import com.turkcell.LibraryApp_ddd.domain.publisher.model.PublisherId;

import java.util.List;
import java.util.Optional;

public interface PublisherRepository {

    Publisher save(Publisher publisher);

    Optional<Publisher> findById(PublisherId id);

    List<Publisher> getAllPublishers();

    List<Publisher> findAllPaged(Integer pageIndex, Integer pageSize);

    void deleteMemberById(PublisherId id);


}
