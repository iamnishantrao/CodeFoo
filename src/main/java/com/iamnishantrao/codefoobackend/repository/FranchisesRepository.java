package com.iamnishantrao.codefoobackend.repository;

import com.iamnishantrao.codefoobackend.model.FranchisesModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchisesRepository extends CrudRepository<FranchisesModel, Integer> {
}
