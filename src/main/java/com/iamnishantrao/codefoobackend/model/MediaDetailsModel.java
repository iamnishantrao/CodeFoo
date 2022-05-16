package com.iamnishantrao.codefoobackend.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "MediaDetails", indexes = @Index(name = "media_details_index", columnList = "id"))
public class MediaDetailsModel {

    @Id
    private int id;
    private String mediaType;
    private String name;
    private String shortName;
    @Lob
    private String longDescription;
    @Lob
    private String shortDescription;
    private Date createdAt;
    private Date updatedAt;
    private String reviewUrl;
    private String reviewScore;
    private String slung;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "mediaDetailsId", referencedColumnName = "id")
    private List<CreatedByModel> createdBy;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "mediaDetailsId", referencedColumnName = "id")
    private List<PublishedByModel> publishedBy;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "mediaDetailsId", referencedColumnName = "id")
    private List<FranchisesModel> franchises;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "mediaDetailsId", referencedColumnName = "id")
    public List<GenresModel> genres;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "mediaDetailsId", referencedColumnName = "id")
    private List<RegionsModel> regions;

    public MediaDetailsModel() {
    }

    public MediaDetailsModel(int id, String mediaType, String name, String shortName, String longDescription, String shortDescription, Date createdAt, Date updatedAt, String reviewUrl, String reviewScore, String slung) {
        this.id = id;
        this.mediaType = mediaType;
        this.name = name;
        this.shortName = shortName;
        this.longDescription = longDescription;
        this.shortDescription = shortDescription;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.reviewUrl = reviewUrl;
        this.reviewScore = reviewScore;
        this.slung = slung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getReviewUrl() {
        return reviewUrl;
    }

    public void setReviewUrl(String reviewUrl) {
        this.reviewUrl = reviewUrl;
    }

    public String getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(String reviewScore) {
        this.reviewScore = reviewScore;
    }

    public String getSlung() {
        return slung;
    }

    public void setSlung(String slung) {
        this.slung = slung;
    }

    public List<CreatedByModel> getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(List<CreatedByModel> createdBy) {
        this.createdBy = createdBy;
    }

    public List<PublishedByModel> getPublishedBy() {
        return publishedBy;
    }

    public void setPublishedBy(List<PublishedByModel> publishedBy) {
        this.publishedBy = publishedBy;
    }

    public List<FranchisesModel> getFranchises() {
        return franchises;
    }

    public void setFranchises(List<FranchisesModel> franchises) {
        this.franchises = franchises;
    }

    public List<GenresModel> getGenres() {
        return genres;
    }

    public void setGenres(List<GenresModel> genres) {
        this.genres = genres;
    }

    public List<RegionsModel> getRegions() {
        return regions;
    }

    public void setRegions(List<RegionsModel> regions) {
        this.regions = regions;
    }
}
