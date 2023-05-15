package com.pjwstk.movieService.repository;

import com.pjwstk.movieService.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepository extends JpaRepository<Movie, Long> {

}
