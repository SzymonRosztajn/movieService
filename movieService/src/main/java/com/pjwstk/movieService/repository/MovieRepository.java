package com.pjwstk.movieService.repository;

import com.pjwstk.movieService.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {


    List<Movie> findAll();

    Optional<Movie> findById(Long id);

    default void setMovieAvailable(Long id) {
        Optional<Movie> optionalMovie = findById(id);
        optionalMovie.ifPresent(movie -> {
            movie.setAvailable(true);
            save(movie);
        });
    }
}
