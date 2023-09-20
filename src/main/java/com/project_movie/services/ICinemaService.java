package com.project_movie.services;

import com.project_movie.dtos.CinemaDTO;
import com.project_movie.entities.Cinema;

import java.util.List;

public interface ICinemaService {
    List<CinemaDTO> getCinemaesThatShowTheMovie(Integer movieId);

    List<Cinema> getAllCinemas();

    Cinema getCinemaById(int id);

    Cinema createCinema(Cinema cinema);

    Cinema updateCinema(int id, Cinema updatedCinema);

    void deleteCinema(int id);
}
