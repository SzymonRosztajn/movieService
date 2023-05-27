package com.pjwstk.movieService.service;


import com.pjwstk.movieService.model.Movie;
import com.pjwstk.movieService.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    private final List<Movie> movies = new ArrayList<>();

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow();

    }

    public Movie saveMovie(Movie movie) {
        movies.add(movie);
        return movieRepository.save(movie);
    }
    public void setMovieAvailable(Long id) {
        movieRepository.setMovieAvailable(id);
    }
}
