package com.project_movie.repositories;

import com.project_movie.entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICinemaRepository extends JpaRepository<Cinema, Integer> {
    @Query("SELECT b FROM Cinema b where b.id in " +
            "(SELECT s.cinema.id FROM Schedule s JOIN s.movie m WHERE s.movie.id = :movieId )")
    List<Cinema> getCinemaThatShowTheMovie(@Param("movieId") Integer movieId);
}
