package com.testAnalysteProgrammeur.testAnalysteProgrammeur.mappers;

import com.testAnalysteProgrammeur.testAnalysteProgrammeur.DTOs.GetFilmDto;
import com.testAnalysteProgrammeur.testAnalysteProgrammeur.DTOs.PostFilmDto;
import com.testAnalysteProgrammeur.testAnalysteProgrammeur.entities.Film;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    PostFilmDto filmToFilmDto(Film film);

    Film postfilmDtoToFilm(PostFilmDto postFilmDto);

    GetFilmDto filmToGetFilmDto(Film film);
}
