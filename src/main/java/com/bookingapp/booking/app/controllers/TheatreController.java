package com.bookingapp.booking.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bookingapp.booking.app.models.Theatre;
import com.bookingapp.booking.app.service.TheatreService;

@RestController
@RequestMapping("/theatres")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    // 🎬 Add a new theatre
    @PostMapping
    public Theatre addTheatre(@RequestBody Theatre theatre) {
        return theatreService.addTheatre(theatre);
    }

    // 🎬 Get all theatres
    @GetMapping
    public List<Theatre> getAllTheatres() {
        return theatreService.getAllTheatres();
    }

    // 🎬 Get a theatre by ID
    @GetMapping("/{id}")
    public Theatre getTheatreById(@PathVariable Long id) {
        return theatreService.getTheatreById(id);
    }

    // 🎬 Update theatre details (partial update)
    @PatchMapping("/{id}")
    public Theatre updateTheatre(@PathVariable Long id, @RequestBody Theatre updatedTheatre) {
        return theatreService.updateTheatre(id, updatedTheatre);
    }

    // 🎬 Delete theatre
    @DeleteMapping("/{id}")
    public String deleteTheatre(@PathVariable Long id) {
        theatreService.deleteTheatre(id);
        return "Theatre with id " + id + " deleted successfully.";
    }
}
