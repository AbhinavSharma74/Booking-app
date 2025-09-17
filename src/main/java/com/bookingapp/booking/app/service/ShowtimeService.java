package com.bookingapp.booking.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingapp.booking.app.models.Showtime;
import com.bookingapp.booking.app.repositories.ShowtimeRepository;

@Service
public class ShowtimeService {

    @Autowired
    private ShowtimeRepository showtimeRepository;

    // Add a new showtime
    public Showtime addShowtime(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    // Get all showtimes
    public List<Showtime> getAllShowtimes() {
        return showtimeRepository.findAll();
    }

    // Get showtime by ID
    public Showtime getShowtimeById(Long id) {
        return showtimeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Showtime not found with id: " + id));
    }

    // Delete showtime
    public void deleteShowtime(Long id) {
        if (showtimeRepository.existsById(id)) {
            showtimeRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Showtime with id: " + id + " not found!");
        }
    }

    // Update available seats
    public Showtime updateSeats(Long id, int seats) {
        Showtime showtime = getShowtimeById(id);
        showtime.setAvailableSeats(seats);
        return showtimeRepository.save(showtime);
    }

    // Example: Get showtimes for a specific movie
    public List<Showtime> getShowtimesByMovie(Long movieId) {
        // You can add a custom query method in repository like:
        // List<Showtime> findByMovie_Id(Long movieId);
        throw new UnsupportedOperationException("Implement query in repository first");
    }
}
