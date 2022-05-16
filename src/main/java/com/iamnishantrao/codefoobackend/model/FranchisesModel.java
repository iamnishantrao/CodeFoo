package com.iamnishantrao.codefoobackend.model;

import javax.persistence.*;

@Entity
@Table(name = "Franchises")
public class FranchisesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String franchise;

    public FranchisesModel() {
    }

    public FranchisesModel(String franchise) {
        this.franchise = franchise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFranchise() {
        return franchise;
    }

    public void setFranchise(String franchise) {
        this.franchise = franchise;
    }
}
