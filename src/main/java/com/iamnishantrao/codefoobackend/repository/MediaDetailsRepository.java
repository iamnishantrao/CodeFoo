package com.iamnishantrao.codefoobackend.repository;

import com.iamnishantrao.codefoobackend.model.MediaDetailsModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediaDetailsRepository extends CrudRepository<MediaDetailsModel, Integer> {

    boolean existsByName(String name);
    MediaDetailsModel findByName(String name);

    List<MediaDetailsModel> findAllByMediaType(String mediaType);

    List<MediaDetailsModel> findAllByIdIn(List<Integer> ids);

    List<MediaDetailsModel> findTop10ByOrderByCreatedAtDesc();
}
