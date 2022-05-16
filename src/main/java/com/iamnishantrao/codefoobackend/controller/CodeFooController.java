package com.iamnishantrao.codefoobackend.controller;

import com.iamnishantrao.codefoobackend.helper.CodeFooHelper;
import com.iamnishantrao.codefoobackend.model.MediaDetailsModel;
import com.iamnishantrao.codefoobackend.service.CodeFooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin("https://localhost:8080")
@Controller
@RequestMapping("/api/csv")
public class CodeFooController {

    @Autowired
    CodeFooService codeFooService;

    //read and upload a CSV file to the database
    @PostMapping("/upload")
    public ResponseEntity<String> uploadCsvFile(@RequestParam("file") MultipartFile file) {

        String message = "";

        if (CodeFooHelper.isCsvFormat(file)) {
            try {
                codeFooService.save(file);
                message = "File successfully uploaded to database! " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body("\"Message successful\": " + message);
            } catch (Exception e) {
                message = "File failed to upload to database! " + file.getOriginalFilename() + " " + e.getMessage();
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("\"Message expectation failed\": " + message);
            }
        }

        message = "Please upload a CSV file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("\"Message\": " + message);
    }

    //get a movie by name
    @GetMapping("/getMovieByName/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String name) {

        MediaDetailsModel media = codeFooService.getMovieByName(name);

        if (media != null) {
            return ResponseEntity.status(HttpStatus.OK).body(media);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie with the name not found!");
        }
    }

    //get all media by a specific media type
    @GetMapping("/getMediaByMediaType/{mediaType}")
    public ResponseEntity getMediaByMediaType(@PathVariable("mediaType") String mediaType) {

        List<MediaDetailsModel> media = codeFooService.getMediaByMediaType(mediaType);

        if (media.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(media);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No media found with media type!");
        }
    }

    //get all media by a specific region
    @GetMapping("/getMediaByRegion/{region}")
    public ResponseEntity getMediaByRegion(@PathVariable("region") String region) {

        try {
            List<MediaDetailsModel> media = codeFooService.getMediaByRegion(region);
            return ResponseEntity.status(HttpStatus.OK).body(media);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No media with this media type found!" + e.getMessage());
        }
    }

    //get top n latest created entries
    @GetMapping("/getTopTenCreatedBy")
    public ResponseEntity getTopTenCreatedBy() {

        try {
            List<MediaDetailsModel> media = codeFooService.getTopTenEntries();
            return ResponseEntity.status(HttpStatus.OK).body(media);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Failed to search entries! " + e.getMessage());
        }
    }
}
