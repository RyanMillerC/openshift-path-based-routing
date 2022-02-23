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
            repository.save(new ThemeParkRide("Skyrush", "Ride the edge and feel the rush!", 4, 4));
            repository.save(new ThemeParkRide("Storm Runner", "Now get ready, here we go!", 4, 5));
            repository.save(new ThemeParkRide("Great Bear", "Feel the roar of Great Bear!", 5, 4));
        };
    }
}
