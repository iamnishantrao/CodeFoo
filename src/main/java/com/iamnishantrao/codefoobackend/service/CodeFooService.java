package com.iamnishantrao.codefoobackend.service;

import com.iamnishantrao.codefoobackend.helper.CodeFooHelper;
import com.iamnishantrao.codefoobackend.model.MediaDetailsModel;
import com.iamnishantrao.codefoobackend.model.RegionsModel;
import com.iamnishantrao.codefoobackend.repository.MediaDetailsRepository;
import com.iamnishantrao.codefoobackend.repository.RegionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CodeFooService {

    @Autowired
    MediaDetailsRepository mediaDetailsRepository;

    @Autowired
    RegionsRepository regionsRepository;

    //method to save csv file data to database
    public void save(MultipartFile file) {

        try {
            List<MediaDetailsModel> mediaDetailsList = CodeFooHelper.readCsv(file.getInputStream());
            mediaDetailsRepository.saveAll(mediaDetailsList);
        } catch (IOException e) {
            throw new RuntimeException("Fail to save the data: " + e.getMessage());
        }
    }

    //get movie by name
    public MediaDetailsModel getMovieByName(String name) {

        if (mediaDetailsRepository.existsByName(name)) {
            try {
                MediaDetailsModel mediaDetailsModel = mediaDetailsRepository.findByName(name);
                return mediaDetailsModel;
            } catch (Exception e) {
                throw new RuntimeException("Exception occurred in getting movie by name: " + e.getMessage());
            }
        } else {
            return null;
        }
    }

    //get media by media type
    public List<MediaDetailsModel> getMediaByMediaType(String mediaType) {

        try {
            List<MediaDetailsModel> mediaDetailsModels = mediaDetailsRepository.findAllByMediaType(mediaType);
            return mediaDetailsModels;
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in getting media by type: " + e.getMessage());
        }
    }

    //get media by media region
    public List<MediaDetailsModel> getMediaByRegion(String region) {

        try {
            List<RegionsModel> regionsModels = regionsRepository.getAllByRegion(region);
            List<Integer> list = new ArrayList<>();
            for (RegionsModel model : regionsModels ) {
                list.add(model.getId());
            }

            List<MediaDetailsModel> mediaDetailsModels = mediaDetailsRepository.findAllByIdIn(list);
            return mediaDetailsModels;
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in getting media by region: " + e.getMessage());
        }
    }

    //get top n entries created from the table based on created at
    public List<MediaDetailsModel> getTopTenEntries() {

        try {
            List<MediaDetailsModel> mediaDetailsModels = mediaDetailsRepository.findTop10ByOrderByCreatedAtDesc();
            return mediaDetailsModels;
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in getting top n media: " + e.getMessage());
        }
    }
}
