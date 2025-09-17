package com.bookingapp.booking.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bookingapp.booking.app.models.Showtime;
import com.bookingapp.booking.app.service.ShowtimeService;

@RestController
@RequestMapping("/showtimes")
public class ShowtimeController {

    @Autowired
    private ShowtimeService showtimeService;

    // Add new showtime
    @PostMapping
    public Showtime addShowtime(@RequestBody Showtime showtime) {
        return showtimeService.addShowtime(showtime);
    }

    // Get all showtimes
    @GetMapping
    public List<Showtime> getAllShowtimes() {
        return showtimeService.getAllShowtimes();
    }

    // Get showtime by ID
    @GetMapping("/{id}")
    public Showtime getShowtimeById(@PathVariable Long id) {
        return showtimeService.getShowtimeById(id);
    }

    // Delete a showtime
    @DeleteMapping("/{id}")
    public String deleteShowtime(@PathVariable Long id) {
        showtimeService.deleteShowtime(id);
        return "Showtime with id " + id + " deleted.";
    }

    // Update seats for a showtime
    @PatchMapping("/{id}/seats")
    public Showtime updateSeats(@PathVariable Long id, @RequestBody int seats) {
        return showtimeService.updateSeats(id, seats);
    }
}
