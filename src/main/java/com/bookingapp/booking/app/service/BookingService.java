package com.bookingapp.booking.app.service;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bookingapp.booking.app.models.Booking;
import com.bookingapp.booking.app.models.Showtime;
import com.bookingapp.booking.app.repositories.BookingRepository;
import com.bookingapp.booking.app.repositories.ShowtimeRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ShowtimeRepository showtimeRepository;

    // Book tickets for a specific showtime
    public Booking bookTickets(Long showtimeId, String username, int seats) {
        Showtime showtime = showtimeRepository.findById(showtimeId)
                .orElseThrow(() -> new EntityNotFoundException("Showtime not found!"));

        // Check seat availability
        if (showtime.getAvailableSeats() < seats) {
            throw new IllegalArgumentException("Not enough seats available. Only " 
                    + showtime.getAvailableSeats() + " left.");
        }

        // Deduct seats
        showtime.setAvailableSeats(showtime.getAvailableSeats() - seats);
        showtimeRepository.save(showtime);

        // Create booking
        Booking booking = new Booking();
        booking.setUsername(username);
        booking.setSeatsBooked(seats);
        booking.setMovie(showtime.getMovie());
        booking.setTheatre(showtime.getTheater());
        booking.setShowtime(showtime);

        return bookingRepository.save(booking);
    }

    // Get bookings by movie title
    public List<Booking> getBookingsByMovieTitle(String title) {
        List<Booking> bookings = bookingRepository.findByMovie_Title(title);

        if (bookings.isEmpty()) {
            throw new EntityNotFoundException("No bookings found for movie: " + title);
        }
        return bookings;
    }

    // Get bookings by username
    public List<Booking> getBookingsByUsername(String username) {
        return bookingRepository.findByUsername(username);
    }

    // Get all bookings sorted by username
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll(Sort.by(Sort.Direction.ASC, "username"));
    }
}
