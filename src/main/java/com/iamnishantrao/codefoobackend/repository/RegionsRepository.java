package com.iamnishantrao.codefoobackend.repository;

import com.iamnishantrao.codefoobackend.model.RegionsModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionsRepository extends CrudRepository<RegionsModel, Integer> {

    List<RegionsModel> getAllByRegion(String region);
}
