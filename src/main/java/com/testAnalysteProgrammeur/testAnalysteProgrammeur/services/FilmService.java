package com.testAnalysteProgrammeur.testAnalysteProgrammeur.services;

import com.testAnalysteProgrammeur.testAnalysteProgrammeur.entities.Film;

import java.util.Optional;

public interface FilmService {
    public Optional<Film> getFilmById(long id);

    public void createFilm(Film newFilm);
}
