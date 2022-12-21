package com.sparta.homewokrweek01.controller;

import com.sparta.homewokrweek01.models.Person;
import com.sparta.homewokrweek01.models.PersonRepository;
import com.sparta.homewokrweek01.models.PersonRequestDto;
import com.sparta.homewokrweek01.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PersonController {

    private final PersonRepository repository;
    private final PersonService service;

    @GetMapping("/api/persons")
    public List<Person> getPerson() {
        return repository.findAll();
    }

    @PostMapping("/api/persons")
    public Person createPerson(@RequestBody PersonRequestDto requestDto) {
        Person person = new Person(requestDto);
        return repository.save(person);
    }

    @PutMapping("/api/persons/{id}")
    public Long updatePerson(@PathVariable Long id, @RequestBody PersonRequestDto requestDto) {
        return service.update(id, requestDto);
    }

    @DeleteMapping("/api/persons{id}")
    public Long deletePerson(@PathVariable Long id) {
        repository.deleteById(id);
        return id;
    }
}