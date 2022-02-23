package com.tomgregory;

import com.tomgregory.entity.ThemeParkRide;
import com.tomgregory.repository.ThemeParkRideRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ThemeParkApplication  {
    public static void main(String[] args) {
        SpringApplication.run(ThemeParkApplication.class);
    }

    @Bean
    public CommandLineRunner sampleData(ThemeParkRideRepository repository) {
        return (args) -> {
            repository.save(new ThemeParkRide("BATWING", "Fly Like a Bat. We Provide the Wings.", 4, 3));
            repository.save(new ThemeParkRide("SUPERMAN™: Ride of Steel", "See What all the Hype is About.", 5, 2));
            repository.save(new ThemeParkRide("THE JOKER's™ Jinx", "Only a Twisted Mind Could Devise Twists Like These.", 2, 5));
        };
    }
}
