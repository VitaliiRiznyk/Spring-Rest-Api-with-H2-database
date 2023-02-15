package com.example.restapp;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "PERSON")
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Temporal(TemporalType.DATE)
    Date bornDate;
    String name;
    String surname;

    public Person(Date bornDate, String name, String surname) {
        this.bornDate = bornDate;
        this.name = name;
        this.surname = surname;
    }
}
