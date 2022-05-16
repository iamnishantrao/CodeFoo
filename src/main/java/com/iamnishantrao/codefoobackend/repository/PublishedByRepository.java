package com.iamnishantrao.codefoobackend.repository;

import com.iamnishantrao.codefoobackend.model.PublishedByModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishedByRepository extends CrudRepository<PublishedByModel, Integer> {
}
