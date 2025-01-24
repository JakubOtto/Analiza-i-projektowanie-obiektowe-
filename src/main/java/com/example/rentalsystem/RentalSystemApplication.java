package com.example.rentalsystem;

import com.example.rentalsystem.model.Property;
import com.example.rentalsystem.repository.PropertyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RentalSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(RentalSystemApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(PropertyRepository repository) {
        return args -> {
            repository.save(new Property("Krakowska 10, Kraków", 2500));
            repository.save(new Property("Warszawska 15, Warszawa", 3200));
            repository.save(new Property("Gdańska 5, Gdańsk", 2800));
        };
    }
}