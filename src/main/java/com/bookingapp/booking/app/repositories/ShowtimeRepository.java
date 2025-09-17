package com.bookingapp.booking.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingapp.booking.app.models.Showtime;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {

    // ✅ Find all showtimes for a specific movie (by movie id)
    List<Showtime> findByMovie_Id(Long movieId);

    //  Find all showtimes for a specific theater (by theater id)
    List<Showtime> findByTheater_Id(Long theaterId);

}
