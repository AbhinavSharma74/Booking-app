package com.bookingapp.booking.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingapp.booking.app.enums.Genre;
import com.bookingapp.booking.app.models.Movie;

@Repository
public interface MovieDetailsRepository extends JpaRepository<Movie, Long> {

    // Find movie by its exact name
    Movie findByTitle(String title);

    // Find all movies of a given genre
    List<Movie> findByGenre(Genre genre);
}
