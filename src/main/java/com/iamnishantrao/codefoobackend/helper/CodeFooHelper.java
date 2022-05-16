package com.iamnishantrao.codefoobackend.helper;

import com.iamnishantrao.codefoobackend.model.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Component
public class CodeFooHelper {

    private static String TYPE = "text/csv";
    static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");

    public static boolean isCsvFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    //method to read csv and map it to the repository models
    public static List<MediaDetailsModel> readCsv(InputStream is) {

        try (BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(is, "UTF-8")))) {

            CSVParser csvParser = new CSVParser(bufferedReader,
                    CSVFormat.Builder.create(CSVFormat.DEFAULT).setHeader().setSkipHeaderRecord(true).build());
            List<MediaDetailsModel> mediaDetailsList = new ArrayList<>();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

            for (CSVRecord csvRecord: csvParser.getRecords()) {

                MediaDetailsModel mediaDetails = new MediaDetailsModel(
                        Integer.parseInt(csvRecord.get("id")),
                        csvRecord.get("media_type"),
                        csvRecord.get("name"),
                        csvRecord.get("short_name"),
                        csvRecord.get("long_description"),
                        csvRecord.get("short_description"),
                        dateFormat.parse(csvRecord.get("created_at")),
                        dateFormat.parse(csvRecord.get("updated_at")),
                        csvRecord.get("review_url"),
                        csvRecord.get("review_score"),
                        csvRecord.get("slug")
                );

                //add regions to model
                List<String> regions = Arrays.asList(csvRecord.get("regions").replaceAll("[{}]","").split(","));
                List<RegionsModel> regionsModels = new ArrayList<>();
                for (String string : regions) {
                    if (!string.isEmpty()) {
                        RegionsModel regionsModel = new RegionsModel(string);
                        regionsModels.add(regionsModel);
                    }
                }
                if (regionsModels.size() > 0) mediaDetails.setRegions(regionsModels);

                //add genres to model
                List<String> genres = Arrays.asList(csvRecord.get("genres").trim().replaceAll("[{}]", "").split(","));
                List<GenresModel> genresModels = new ArrayList<>();
                for (String string : genres) {
                    if (!string.isEmpty()){
                        GenresModel genresModel = new GenresModel(string);
                        genresModels.add(genresModel);
                    }
                }
                if (genresModels.size() > 0) mediaDetails.setGenres(genresModels);

                //add franchises to model
                List<String> franchises = Arrays.asList(csvRecord.get("franchises").trim().replaceAll("[{}]", "").split(","));
                List<FranchisesModel> franchisesModels = new ArrayList<>();
                for (String string : franchises) {
                    if (!string.isEmpty()) {
                        FranchisesModel franchisesModel = new FranchisesModel(string);
                        franchisesModels.add(franchisesModel);
                    }
                }
                if (franchisesModels.size() > 0) mediaDetails.setFranchises(franchisesModels);

                //add published by to model
                List<String> publishedBy = Arrays.asList(csvRecord.get("published_by").trim().replaceAll("[{}]", "").split(","));
                List<PublishedByModel> publishedByModels = new ArrayList<>();
                for (String string : publishedBy) {
                    if (string.isEmpty()) {
                        PublishedByModel publishedByModel = new PublishedByModel(string);
                        publishedByModels.add(publishedByModel);
                    }
                }
                if (publishedByModels.size() > 0) mediaDetails.setPublishedBy(publishedByModels);

                //add created by to model
                List<String> createdBy = Arrays.asList(csvRecord.get("created_by").trim().replaceAll("[{}]", "").split(","));
                List<CreatedByModel> createdByModels = new ArrayList<>();
                for (String string : createdBy) {
                    if (!string.isEmpty()) {
                        CreatedByModel createdByModel = new CreatedByModel(string);
                        createdByModels.add(createdByModel);
                    }
                }
                if (createdByModels.size() > 0) mediaDetails.setCreatedBy(createdByModels);

                mediaDetailsList.add(mediaDetails);
            }

            return mediaDetailsList;
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
