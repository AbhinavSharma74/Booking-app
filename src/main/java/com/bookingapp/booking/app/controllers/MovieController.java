package com.bookingapp.booking.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bookingapp.booking.app.enums.Genre;
import com.bookingapp.booking.app.models.Movie;
import com.bookingapp.booking.app.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // Add a new movie
    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    // Update (replace) a movie
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie updatedMovie) {
        return ResponseEntity.ok(movieService.updateMovie(id, updatedMovie));
    }

    // Get all movies
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    // Get movie by ID
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return ResponseEntity.of(movieService.getMovieById(id));
    }

    // Get movies by genre
    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable Genre genre) {
        return ResponseEntity.ok(movieService.getMoviesByGenre(genre));
    }

    // Delete movie by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok("Movie with id " + id + " deleted.");
    }
}