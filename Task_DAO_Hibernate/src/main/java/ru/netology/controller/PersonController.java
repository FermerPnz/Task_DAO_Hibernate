package ru.netology.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.model.Person;
import ru.netology.repository.PersonRepository;

import java.util.List;

@RestController
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personRepository.getPersonsByCity(city);
    }

    @GetMapping("/persons/older-than")
    public List<Person> getPersonsOlderThan(@RequestParam int age) {
        return personRepository.getPersonsByAgeGreaterThanOrderByAgeDesc(age);
    }
}