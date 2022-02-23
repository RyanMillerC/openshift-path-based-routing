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
            repository.save(new ThemeParkRide("Skyrush", "Ride the edge and feel the rush! Skyrush roller coaster climbs 200 feet into the air before flying downhill at 75 mph. Experience 4 high speed turns, 5 zero-G airtime hills - all from a thrilling, winged-seat coaster train!", 4, 4));
            repository.save(new ThemeParkRide("Storm Runner", "'Now get ready, here we go!' Storm Runner coaster launches riders from 0-72 mph in 2 seconds flat and that's just the beginning. This one-of-a-kind coaster takes riders through a thrilling 135-foot cobra loop, barrel rolls, a dramatic flying snake dive, and a screeching halt before slowly gliding back into the station.", 4, 5));
            repository.save(new ThemeParkRide("Great Bear", "Feel the roar of Great Bear! This guest favorite, inverted steel coaster leaves your feet dangling as it lifts 90 feet off the ground and launches into a thrilling, yet graceful course of drops, loops, corkscrews, and a zero-g roll that gives riders a scenic view of sooperdooperLooper, Spring Creek, Skyview, and more!", 5, 4));
        };
    }
}
