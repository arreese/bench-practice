package com.kinandcarta.benchpractice.services;

import com.kinandcarta.benchpractice.entities.Person;
import com.kinandcarta.benchpractice.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService{

    private PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<com.kinandcarta.benchpractice.models.Person> getAll() {
        List<Person> all = repository.findAll();
        return all.stream().map(o ->
                new com.kinandcarta.benchpractice.models.Person(o.getFirstName(), o.getLastName(), o.getAge(), o.getOccupation())).collect(Collectors.toList());
    }
}
