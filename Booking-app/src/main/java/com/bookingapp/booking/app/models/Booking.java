package com.bookingapp.booking.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="bookings")
public class Booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private int seatsBooked;

    @ManyToOne
    @JoinColumn (name = "movie_id", nullable=false)
    private MovieDetails movie;

    //getting id
    public long getId(){
        return id;
    }

    //getter setter for username
    public void setUsername(String userName){
        this.userName=userName;
    }

    public String getUsername(){
        return userName;
    }

    //getter setter for Movies
    public MovieDetails getMovie(){
        return movie;
    }

    public void setMovie(MovieDetails movie){
        this.movie=movie;
    }


    //getter setter for seats booked
    public void setSeatsBooked(int seatsBooked){
        this.seatsBooked=seatsBooked;
    }
    public int getSeatsBooked(){
        return seatsBooked;
    }

}