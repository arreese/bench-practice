package com.kinandcarta.benchpractice.services;

import com.kinandcarta.benchpractice.entities.Person;
import com.kinandcarta.benchpractice.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService{

    private final PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<com.kinandcarta.benchpractice.models.Person> getAll() {
        List<Person> all = repository.findAll();
        return all.stream().map(o ->
                new com.kinandcarta.benchpractice.models.Person(o.getFirstName(), o.getLastName(), o.getAge(), o.getOccupation())).collect(Collectors.toList());
    }

    @Override
    public Integer save(com.kinandcarta.benchpractice.models.Person person) {
        Person entity = new Person(person.getFirstName(), person.getLastName(), person.getAge(), person.getOccupation());
        return repository.save(entity).getId();
    }

    @Override
    public com.kinandcarta.benchpractice.models.Person getPerson(Integer id) {
        Optional<Person> possiblePerson = repository.findById(id);
        return possiblePerson.map(p -> new com.kinandcarta.benchpractice.models.Person(p.getFirstName(),
                p.getLastName(), p.getAge(), p.getOccupation())).orElse(null);
    }
}