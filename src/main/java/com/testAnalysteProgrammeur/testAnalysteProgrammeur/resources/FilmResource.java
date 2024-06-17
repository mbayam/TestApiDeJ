package com.testAnalysteProgrammeur.testAnalysteProgrammeur.resources;

import com.testAnalysteProgrammeur.testAnalysteProgrammeur.DTOs.GetFilmDto;
import com.testAnalysteProgrammeur.testAnalysteProgrammeur.DTOs.PostFilmDto;
import com.testAnalysteProgrammeur.testAnalysteProgrammeur.exceptions.FilmNotFoundException;
import com.testAnalysteProgrammeur.testAnalysteProgrammeur.mappers.MapStructMapper;
import com.testAnalysteProgrammeur.testAnalysteProgrammeur.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FilmResource {


    final private FilmService filmService;
    final private MapStructMapper mapstructMapper;

    @Autowired
    public FilmResource(FilmService filmService, MapStructMapper mapstructMapper) {
        this.filmService = filmService;
        this.mapstructMapper = mapstructMapper;
    }


    @PostMapping(value = "/film", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> createFilm(@RequestBody PostFilmDto postFilmDto) {
        filmService.createFilm(mapstructMapper.postfilmDtoToFilm(postFilmDto));
        return new ResponseEntity<String>("Objet Film crée", HttpStatus.CREATED);
    }

    @GetMapping(value = "/film/{id}", produces = "application/json")
    public ResponseEntity<GetFilmDto> getFilmById(@PathVariable long id) {
        var film = filmService.getFilmById(id);
        if (film.isEmpty())
            throw new FilmNotFoundException("Could not find film with id: " + id);

        return new ResponseEntity<GetFilmDto>(mapstructMapper.filmToGetFilmDto(film.get()), HttpStatus.OK);
    }
}
