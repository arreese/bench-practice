package com.kinandcarta.benchpractice.services;

import com.kinandcarta.benchpractice.entities.Person;
import com.kinandcarta.benchpractice.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PersonServiceImplTest {

    @Test
    void getAll() {
        PersonRepository repository = mock(PersonRepository.class);
        when(repository.findAll()).thenReturn(Collections.singletonList(new Person("Mark", "Sage", 102, "Thrillseeker!!!")));
        PersonService service = new PersonServiceImpl(repository);
        List<com.kinandcarta.benchpractice.models.Person> result = service.getAll();
        assertEquals("Mark",result.get(0).getFirstName());
        assertEquals("Sage",result.get(0).getLastName());
        assertEquals(102,result.get(0).getAge());
        assertEquals("Thrillseeker!!!",result.get(0).getOccupation());
    }

    @Test
    void savePerson() {
        PersonRepository repository = mock(PersonRepository.class);
        Person personToSave = new Person("Mark","Sage", 102, "Thrillseeker!!!");
        Person savedPerson = new Person("Mark","Sage", 102, "Thrillseeker!!!");
        ReflectionTestUtils.setField(savedPerson,"id",1123);
        when(repository.save(argThat(getArgumentMatcher(personToSave)))).thenReturn(savedPerson);
        PersonService service = new PersonServiceImpl(repository);
        Integer id = service.save(new com.kinandcarta.benchpractice.models.Person("Mark", "Sage", 102, "Thrillseeker!!!"));
        assertEquals(1123, id);
    }

    private ArgumentMatcher<Person> getArgumentMatcher(Person personToSave) {
        return person -> {
            assertEquals(personToSave.getFirstName(), person.getFirstName());
            assertEquals(personToSave.getLastName(), person.getLastName());
            assertEquals(personToSave.getAge(), person.getAge());
            assertEquals(personToSave.getOccupation(), person.getOccupation());
            return true;
        };
    }
}