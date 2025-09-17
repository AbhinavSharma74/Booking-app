package com.bookingapp.booking.app.models;

import com.bookingapp.booking.app.enums.Genre;
import jakarta.persistence.*;

@Entity
@Table(name = "movie_details")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genre genre;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "theatre", nullable = false)  
    private String theatre;

    // ===== Getters & Setters =====
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Integer getDuration() {
        return duration != null ? duration : 0;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getTheatre() {
        return theatre;
    }

    public void setTheatre(String theatre) {
        this.theatre = theatre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", duration=" + duration +
                ", theatre=" + theatre +
                '}';
    }
}