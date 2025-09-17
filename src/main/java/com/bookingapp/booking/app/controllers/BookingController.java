package com.bookingapp.booking.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bookingapp.booking.app.models.Booking;
import com.bookingapp.booking.app.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Book tickets using showtimeId (not just movieId)
    @PostMapping("/book-now")
    public Booking bookTickets(@RequestParam Long showtimeId, 
                               @RequestParam String username, 
                               @RequestParam int seats) {
        return bookingService.bookTickets(showtimeId, username, seats);
    }

    // Get all bookings
    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    //  Get bookings by username
    @GetMapping("/user/{username}")
    public List<Booking> getBookingsByUsername(@PathVariable String username) {
        return bookingService.getBookingsByUsername(username);
    }

    //  Get bookings by movie title
    @GetMapping("/movie/{title}")
    public List<Booking> getBookingsByMovie(@PathVariable String title) {
        return bookingService.getBookingsByMovieTitle(title);
    }
}
