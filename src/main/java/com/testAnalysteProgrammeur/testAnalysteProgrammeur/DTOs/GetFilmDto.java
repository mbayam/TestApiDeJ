package com.testAnalysteProgrammeur.testAnalysteProgrammeur.DTOs;

import java.util.HashSet;
import java.util.Set;

public class GetFilmDto {

    private long id;
    private String titre;
    private String description;
    Set<ActeurDto> acteurs = new HashSet<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ActeurDto> getActeurs() {
        return acteurs;
    }

    public void setActeurs(Set<ActeurDto> acteurs) {
        this.acteurs = acteurs;
    }
}
