package com.bookingapp.booking.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bookingapp.booking.app.models.MovieDetails;
import com.bookingapp.booking.app.enums.Genre;

@Repository
public interface MovieDetailsRepository extends JpaRepository<MovieDetails, Long>{
    
    MovieDetails findByMovie(String movie);
    List<MovieDetails> findByGenre(Genre genre);
    
}