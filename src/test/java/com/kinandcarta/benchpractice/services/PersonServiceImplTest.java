package com.kinandcarta.benchpractice.services;

import com.kinandcarta.benchpractice.entities.Person;
import com.kinandcarta.benchpractice.repositories.PersonRepository;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PersonServiceImplTest {

    @Test
    void getAll() {
        PersonRepository repository = mock(PersonRepository.class);
        when(repository.findAll()).thenReturn(Arrays.asList(new Person(1, "Mark","Sage", 102, "Thrillseeker!!!")));
        PersonService service = new PersonServiceImpl(repository);
        List<com.kinandcarta.benchpractice.models.Person> result = service.getAll();
        assertEquals("Mark",result.get(0).getFirstName());
        assertEquals("Sage",result.get(0).getLastName());
        assertEquals(102,result.get(0).getAge());
        assertEquals("Thrillseeker!!!",result.get(0).getOccupation());
    }
}