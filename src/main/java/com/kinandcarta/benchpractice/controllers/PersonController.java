package com.kinandcarta.benchpractice.controllers;

import com.kinandcarta.benchpractice.models.Person;
import com.kinandcarta.benchpractice.services.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("")
    public @ResponseBody List<Person> getAll(){
        return service.getAll();
    }
}
