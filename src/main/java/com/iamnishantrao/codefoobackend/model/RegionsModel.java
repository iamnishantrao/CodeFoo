package com.iamnishantrao.codefoobackend.model;

import javax.persistence.*;

@Entity
@Table(name = "Regions")
public class RegionsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String region;

    public RegionsModel() {
    }

    public RegionsModel(String regions) {
        this.region = regions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String regions) {
        this.region = regions;
    }
}
