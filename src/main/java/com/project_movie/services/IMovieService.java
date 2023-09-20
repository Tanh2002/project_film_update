package com.project_movie.services;

import com.project_movie.dtos.MovieDTO;
import com.project_movie.entities.Movie;

import java.util.List;

public interface IMovieService {
    List<MovieDTO> findAllShowingMovies();

    MovieDTO getById(Integer movieId);

    List<MovieDTO> findAllShowingMoviesByName(String keyword);

    Movie createMovie(Movie movie);

    Movie updateMovie(int id, Movie updatedMovie);

    void deleteMovie(int id);
}
