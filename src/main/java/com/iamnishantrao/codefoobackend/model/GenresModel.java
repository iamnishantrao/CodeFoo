package com.iamnishantrao.codefoobackend.model;

import javax.persistence.*;

@Entity
@Table(name = "Genres")
public class GenresModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String genre;

    public GenresModel() {
    }

    public GenresModel(String genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}