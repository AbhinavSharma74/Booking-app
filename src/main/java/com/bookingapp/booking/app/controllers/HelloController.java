package com.bookingapp.booking.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping("/")
    public String home(){
        return "Welcome to Booking App 🚀";
    }

    @PostMapping("/hello")
    public String hello(){
        return  "Hello, Abhinav! Your Spring Boot app is working 🎉";
    }
}