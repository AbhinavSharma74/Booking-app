package com.bookingapp.booking.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingapp.booking.app.models.Theatre;
import com.bookingapp.booking.app.repositories.TheatreRepository;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    // Add theatre
    public Theatre addTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    // Get all theatres
    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    // Get theatre by ID
    public Theatre getTheatreById(Long id) {
        return theatreRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Theatre not found with id: " + id));
    }

    // Update theatre
    public Theatre updateTheatre(Long id, Theatre updatedTheatre) {
        return theatreRepository.findById(id).map(theatre -> {
            if (updatedTheatre.getName() != null) {
                theatre.setName(updatedTheatre.getName());
            }
            if (updatedTheatre.getLocation() != null) {
                theatre.setLocation(updatedTheatre.getLocation());
            }
            if (updatedTheatre.getShowtimes() != null) {
                theatre.setShowtimes(updatedTheatre.getShowtimes());
            }
            return theatreRepository.save(theatre);
        }).orElseThrow(() -> new IllegalArgumentException("Theatre not found with id: " + id));
    }

    // Delete theatre
    public void deleteTheatre(Long id) {
        if (theatreRepository.existsById(id)) {
            theatreRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Theatre not found with id: " + id);
        }
    }
}
