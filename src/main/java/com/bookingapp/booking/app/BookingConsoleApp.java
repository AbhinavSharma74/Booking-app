package com.bookingapp.booking.app;

import com.bookingapp.booking.app.models.Booking;
import com.bookingapp.booking.app.models.Movie;
import com.bookingapp.booking.app.models.Showtime;
import com.bookingapp.booking.app.service.BookingService;
import com.bookingapp.booking.app.service.MovieService;
import com.bookingapp.booking.app.service.ShowtimeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class BookingConsoleApp implements CommandLineRunner {

    private final MovieService movieService;
    private final ShowtimeService showtimeService;
    private final BookingService bookingService;

    public BookingConsoleApp(MovieService movieService,
            ShowtimeService showtimeService,
            BookingService bookingService) {
        this.movieService = movieService;
        this.showtimeService = showtimeService;
        this.bookingService = bookingService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookingConsoleApp.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== 🎬 Movie Booking System =====");
            System.out.println("1. View Movies");
            System.out.println("2. View Showtimes by Movie");
            System.out.println("3. Book Ticket");
            System.out.println("4. View My Bookings");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> viewMovies();
                case 2 -> viewShowtimes(scanner);
                case 3 -> bookTicket(scanner);
                case 4 -> viewBookings(scanner);
                case 5 -> {
                    System.out.println("✅ Exiting system. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option, try again.");

            }
        }
    }

    private void viewMovies() {
        List<Movie> movies = movieService.getAllMovies();
        if (movies.isEmpty()) {
            System.out.println("No movies available.");
        } else {
            movies.forEach(System.out::println);
        }
    }

    private void viewShowtimes(Scanner scanner) {
        System.out.print("Enter Movie ID: ");
        Long movieId = Long.parseLong(scanner.nextLine());

        try {
            List<Showtime> showtimes = showtimeService.getShowtimesByMovie(movieId);
            if (showtimes.isEmpty()) {
                System.out.println("No showtimes found for this movie.");
            } else {
                showtimes.forEach(System.out::println);
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("You need to implement `findByMovie_Id` in ShowtimeRepository first.");
        }
    }

    private void bookTicket(Scanner scanner) {
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Showtime ID: ");
        Long showtimeId = Long.parseLong(scanner.nextLine());
        System.out.print("Enter number of seats: ");
        int seats = Integer.parseInt(scanner.nextLine());

        try {
            Booking booking = bookingService.bookTickets(showtimeId, username, seats);
            System.out.println("✅ Booking successful! Confirmation:");
            System.out.println(booking);
        } catch (Exception e) {
            System.out.println("Booking failed: " + e.getMessage());

        }
    }

    private void viewBookings(Scanner scanner) {
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        List<Booking> bookings = bookingService.getBookingsByUsername(username);
        if (bookings.isEmpty()) {
            System.out.println("No bookings found for user: " + username);
        } else {
            bookings.forEach(System.out::println);
        }
    }
}