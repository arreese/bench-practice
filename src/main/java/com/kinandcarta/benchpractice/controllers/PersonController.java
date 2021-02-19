package com.kinandcarta.benchpractice.controllers;

import com.kinandcarta.benchpractice.models.Person;
import com.kinandcarta.benchpractice.services.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public @ResponseBody List<Person> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public @ResponseBody Person getPerson(@PathVariable Integer id){
        return service.getPerson(id);
    }
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Person person) throws URISyntaxException {
        Integer id = service.save(person);
        return ResponseEntity.created(new URI("/persons/" + id)).build();
    }
}