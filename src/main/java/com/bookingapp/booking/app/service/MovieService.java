package com.bookingapp.booking.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingapp.booking.app.enums.Genre;
import com.bookingapp.booking.app.models.Movie;
import com.bookingapp.booking.app.repositories.MovieRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieDetailsRepository;

    // Add a movie
    public Movie addMovie(Movie movie) {
        return movieDetailsRepository.save(movie);
    }

    // Get all movies
    public List<Movie> getAllMovies() {
        return movieDetailsRepository.findAll();
    }

    // Get movie by ID
    public Optional<Movie> getMovieById(Long id) {
        return movieDetailsRepository.findById(id);
    }

    // Get movies by genre
    public List<Movie> getMoviesByGenre(Genre genre) {
        return movieDetailsRepository.findByGenre(genre);
    }

    // Delete a movie
    public void deleteMovie(Long id) {
        if (movieDetailsRepository.existsById(id)) {
            movieDetailsRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Movie with id " + id + " not found!");
        }
    }

    public Movie updateMovie(Long id, Movie updatedMovie) {
        Movie existing = movieDetailsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id " + id));

        if (updatedMovie.getTitle() != null) {
            existing.setTitle(updatedMovie.getTitle());
        }
        if (updatedMovie.getGenre() != null) {
            existing.setGenre(updatedMovie.getGenre());
        }
        if (updatedMovie.getDuration() != null) {
            existing.setDuration(updatedMovie.getDuration());
        }

        return movieDetailsRepository.save(existing);
    }

}