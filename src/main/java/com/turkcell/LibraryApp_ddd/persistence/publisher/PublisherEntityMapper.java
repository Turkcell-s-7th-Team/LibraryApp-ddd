package com.turkcell.LibraryApp_ddd.persistence.publisher;

import com.turkcell.LibraryApp_ddd.domain.publisher.model.Address;
import com.turkcell.LibraryApp_ddd.domain.publisher.model.Publisher;
import com.turkcell.LibraryApp_ddd.domain.publisher.model.PublisherId;
import org.springframework.stereotype.Component;

@Component
public class PublisherEntityMapper {

    public JpaPublisherEntity toEntity(Publisher publisher) {
        JpaPublisherEntity entity = new JpaPublisherEntity();
        entity.setId(publisher.id().value());
        entity.setName(publisher.name());
        entity.setAddress(publisher.address().toString());
        return entity;
    }

    public Publisher toDomain(JpaPublisherEntity entity) {
        return Publisher.rehydrate(new PublisherId(entity.id()), entity.name(), new Address(entity.address()));
    }
}
