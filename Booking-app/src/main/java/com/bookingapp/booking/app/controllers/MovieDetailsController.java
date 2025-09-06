package com.bookingapp.booking.app.controllers;

import java.util.List;

import com.bookingapp.booking.app.models.MovieDetails;
import com.bookingapp.booking.app.repositories.MovieDetailsRepository;
import com.bookingapp.booking.app.enums.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/movies")
public class MovieDetailsController {

    @Autowired
    private MovieDetailsRepository repository;

    //adding a new movie
    @PostMapping
    public MovieDetails addMovies(@RequestBody MovieDetails movie){
        return repository.save(movie);
    }

    //Update partial data
    @PatchMapping("/{id}/theatre")
    public MovieDetails updateTheatre(@PathVariable Long id,@RequestBody String theatre){
        return repository.findById(id).map(movie -> {
        movie.setTheatre(theatre);
        return repository.save(movie);
        }).orElse(null);

    }

    //get all movies(Get/movies)
    @GetMapping
    public List<MovieDetails> getAllMovies(){
        return repository.findAll();
    }

    //get movies by id(Get movies/id/{id})
    @GetMapping("/{id}")
    public MovieDetails getMovieById(@PathVariable Long id){
        return repository.findById(id).orElse(null);
    }


    //get movies by genre (Get/movie/genre/{genre})
    @GetMapping("/genre/{genre}")
    public List<MovieDetails> getMovieWithGenre(@PathVariable Genre genre){
        return repository.findByGenre(genre);
    }

    
}