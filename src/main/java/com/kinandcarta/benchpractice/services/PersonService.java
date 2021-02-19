
package com.kinandcarta.benchpractice.services;

import com.kinandcarta.benchpractice.models.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAll();

    Integer save(Person person);

    Person getPerson(Integer id);
}