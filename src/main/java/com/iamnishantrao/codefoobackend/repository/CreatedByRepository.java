package com.iamnishantrao.codefoobackend.repository;

import com.iamnishantrao.codefoobackend.model.CreatedByModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatedByRepository extends CrudRepository<CreatedByModel, Integer> {
}
