package com.example.restapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@SpringBootApplication
@RestController
@AllArgsConstructor
public class RestAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestAppApplication.class, args);
    }

    private final PersonService personService;
    private final PersonRepository personRepository;

    @Bean
    public CommandLineRunner startRun(final PersonRepository personRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                personRepository.save(new Person(Date.valueOf("1997-12-27"), "Verona", "Sybirova"));
            }
        };
    }

    @GetMapping("/{id}")
    public Person response(@PathVariable Long id) {
        return personService.gson(id);
    }

}
