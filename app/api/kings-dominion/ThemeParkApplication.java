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
            repository.save(new ThemeParkRide("Flight of Fear", "Get ready for an adrenaline rush like no other when you catapult from zero to 54 miles per hour in just four seconds on this heart-pounding adventure in total darkness through four inversions.", 5, 5));
            repository.save(new ThemeParkRide("Grizzly", "Adventure-seekers are sent roaring through 3,150 feet of track through a dense forest on this popular wooden roller coaster. The double-figure-eight layout makes for an exhilarating ride! ", 3, 2));
            repository.save(new ThemeParkRide("Anaconda", "Get wrapped in the coils and be prepared to drop 144 feet into the depths of the Anaconda. You'll be rocketed through 2,700 feet of track at speeds up to 50 miles per hour through an underwater tunnel, vertical loops, sharp twists, and turns.", 5, 5));
        };
    }
}
