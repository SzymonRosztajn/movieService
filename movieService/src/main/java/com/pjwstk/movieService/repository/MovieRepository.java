package com.pjwstk.movieService.repository;

import com.pjwstk.movieService.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m")
    List<Movie> findAllMovies();

    @Query("SELECT m FROM Movie m WHERE m.id = :id")
    Movie findMovieById(@Param("id") Long id);

    @Modifying
    @Query("UPDATE Movie m SET m.isAvailable = true WHERE m.id = :id")
    void setMovieAvailable(@Param("id") Long id);
}
