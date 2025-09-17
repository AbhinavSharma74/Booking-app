package com.bookingapp.booking.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingapp.booking.app.enums.Genre;
import com.bookingapp.booking.app.models.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    // Correct method to find bookings by movie title
    List<Booking> findByMovie_Title(String title);


    // Bookings by genre
    List<Booking> findByGenre(Genre genre);

    // Bookings by username
    List<Booking> findByUsername(String username);

}