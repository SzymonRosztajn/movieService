package com.pjwstk.movieService.controller;


import com.pjwstk.movieService.model.Movie;
import com.pjwstk.movieService.service.MovieService;
import jakarta.persistence.Id;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieApp")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> createCar(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.saveMovie(movie));
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        Movie Movie = movieService.getMovieById(id);
        if (Movie == null) {
            return ResponseEntity.notFound().build();
        }
        movie.setId(1);
        return ResponseEntity.ok(movieService.saveMovie(movie));
    }
    @PatchMapping("/movies/{id}")
    public ResponseEntity<Movie> setMovieAsAvailable(@PathVariable Long id) {
        Movie updatedMovie = movieService.setMovieAvailable(id);
        return ResponseEntity.ok(updatedMovie);
    }
}