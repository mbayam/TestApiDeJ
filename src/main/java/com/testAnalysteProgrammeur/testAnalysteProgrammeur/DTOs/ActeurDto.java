package com.testAnalysteProgrammeur.testAnalysteProgrammeur.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ActeurDto {
    @JsonIgnore
    private long id;
    private String nom;
    private String prenom;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
