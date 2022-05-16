package com.iamnishantrao.codefoobackend.repository;

import com.iamnishantrao.codefoobackend.model.GenresModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenresRepository extends CrudRepository<GenresModel, Integer> {
}
