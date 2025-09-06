package com.bookingapp.booking.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingapp.booking.app.enums.Genre;
import com.bookingapp.booking.app.models.Booking;
import com.bookingapp.booking.app.models.MovieDetails;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
    
    List<Booking> findByUsername(String username);
    MovieDetails findByMovie(String movie);
    List<MovieDetails> findByGenre(Genre genre);
}
