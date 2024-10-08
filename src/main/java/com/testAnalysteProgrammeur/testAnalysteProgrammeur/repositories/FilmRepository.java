package com.testAnalysteProgrammeur.testAnalysteProgrammeur.repositories;

import com.testAnalysteProgrammeur.testAnalysteProgrammeur.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
}
