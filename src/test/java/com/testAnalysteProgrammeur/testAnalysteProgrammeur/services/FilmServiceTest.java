package com.testAnalysteProgrammeur.testAnalysteProgrammeur.services;

import com.testAnalysteProgrammeur.testAnalysteProgrammeur.entities.Acteur;
import com.testAnalysteProgrammeur.testAnalysteProgrammeur.entities.Film;
import com.testAnalysteProgrammeur.testAnalysteProgrammeur.repositories.FilmRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FilmServiceTest {

    private final static String TITLE="Rambo";
    private final static String DESCRIPTION = "Film d'action";

    @Mock
    private FilmRepository filmRepositoryMock;

    @InjectMocks
    private FilmServiceImpl filmService;

    private static Acteur acteur1;
    private static Acteur acteur2;
    private static Film film;

    @BeforeAll
    public static void setUp(){
        acteur1 = new Acteur(1, "Ford", "Lity");
        acteur2 = new Acteur(2, "Falonne", "Mbaya");
        film = new Film();
        film.setId(1L);
        film.setTitre(TITLE);
        film.setDescription(DESCRIPTION);
        film.getActeurs().add(acteur1);
        film.getActeurs().add(acteur2);
    }

    @Test
    void findFilmByIdTestShouldSucceed(){
        when(filmRepositoryMock.findById(1L)).thenReturn(Optional.of(film));
        Film resultFilm = filmService.getFilmById(1L).get();
        Assertions.assertEquals(TITLE, resultFilm.getTitre());
        Assertions.assertEquals(DESCRIPTION, resultFilm.getDescription());
        var acteurs = resultFilm.getActeurs();
        Assertions.assertTrue(acteurs.contains(acteur1));
        Assertions.assertTrue(acteurs.contains(acteur2));
        Assertions.assertEquals(2, acteurs.size());

    }

    @Test
    void findFilmByIncorrectIdShouldReturnEmpty(){
        when(filmRepositoryMock.findById(2L)).thenReturn(Optional.empty());
        Assertions.assertTrue(filmService.getFilmById(2L).isEmpty());
    }

    @Test
    void createFilmTestShouldSucceed(){
        filmService.createFilm(film);
        verify(filmRepositoryMock).save(film);
        verify(filmRepositoryMock, times(1)).save(film);

    }
}
