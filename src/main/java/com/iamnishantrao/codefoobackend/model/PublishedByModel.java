package com.iamnishantrao.codefoobackend.model;

import javax.persistence.*;

@Entity
@Table(name = "PublishedBy")
public class PublishedByModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String publisher;

    public PublishedByModel() {
    }

    public PublishedByModel(String publishedBy) {
        this.publisher = publishedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publishedBy) {
        this.publisher = publishedBy;
    }
}
