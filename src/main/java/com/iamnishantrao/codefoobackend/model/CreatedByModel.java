package com.iamnishantrao.codefoobackend.model;

import javax.persistence.*;

@Entity
@Table(name = "CreatedBy")
public class CreatedByModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String creator;

    public CreatedByModel() {
    }

    public CreatedByModel(String createdBy) {
        this.creator = createdBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String createdBy) {
        this.creator = createdBy;
    }
}