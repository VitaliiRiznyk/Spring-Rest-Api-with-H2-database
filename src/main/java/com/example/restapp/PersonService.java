package com.example.restapp;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person gson(Long id) {
        if (personRepository.findById(id).isPresent()){
            return personRepository.findById(id).get();
        }
        return null;
    }
}