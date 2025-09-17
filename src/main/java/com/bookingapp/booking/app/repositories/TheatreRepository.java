package com.bookingapp.booking.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingapp.booking.app.models.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {
}
