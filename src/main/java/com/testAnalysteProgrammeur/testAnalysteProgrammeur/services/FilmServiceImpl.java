package com.testAnalysteProgrammeur.testAnalysteProgrammeur.services;

import com.testAnalysteProgrammeur.testAnalysteProgrammeur.entities.Film;
import com.testAnalysteProgrammeur.testAnalysteProgrammeur.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {

    final private FilmRepository filmRepository;

    @Autowired
    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public Optional<Film> getFilmById(long id) {
        return filmRepository.findById(id);
    }

    @Override
    public void createFilm(Film newFilm) {
        filmRepository.save(newFilm);
    }
}
