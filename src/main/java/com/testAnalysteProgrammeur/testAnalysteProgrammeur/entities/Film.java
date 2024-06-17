package com.testAnalysteProgrammeur.testAnalysteProgrammeur.entities;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Film {
    @Id
    @GeneratedValue
    private long id;
    private String titre;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    Set<Acteur> acteurs = new HashSet<>();

    public Film() {
    }

    public Film(long id, String titre, String description, Set<Acteur> acteurs) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.acteurs = acteurs;
    }

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

    public Set<Acteur> getActeurs() {
        return acteurs;
    }

    public void setActeurs(Set<Acteur> acteurs) {
        this.acteurs = acteurs;
    }
}
