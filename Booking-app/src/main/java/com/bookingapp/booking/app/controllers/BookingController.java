package com.bookingapp.booking.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookingapp.booking.app.models.Booking;
import com.bookingapp.booking.app.models.MovieDetails;
import com.bookingapp.booking.app.repositories.BookingRepository;
import com.bookingapp.booking.app.repositories.MovieDetailsRepository;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private MovieDetailsRepository movieDetailsRepository;

    @PostMapping
    public Booking bookTickets(@RequestParam Long movieId, @RequestParam String userName, @RequestParam int seats){
        MovieDetails movie=movieDetailsRepository.findById(movieId).orElse(null);
        if(movie==null){
            System.out.println("Movie not found...");
            return null;
        }else if(movie.getTickets()<seats){
            System.out.println("Desired tickets not available!");
            return null;
        }

        //reducing tickets
        movie.setTickets(movie.getTickets()-seats);
        movieDetailsRepository.save(movie);

        //saving booking
        Booking booking=new Booking();
        booking.setUsername(userName);
        booking.setMovie(movie);
        booking.setSeatsBooked(seats);

        //saving
        return bookingRepository.save(booking);
    }

    //getting all bookings
    @GetMapping
    public List<Booking> bookings(){
        return bookingRepository.findAll();
    }

}