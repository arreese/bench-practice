package com.kinandcarta.benchpractice.controllers;

import com.kinandcarta.benchpractice.models.Person;
import com.kinandcarta.benchpractice.services.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PersonControllerTest {

    @Test
    void getAll() {
        PersonService service = mock(PersonService.class);
        Person person = new Person();
        when(service.getAll()).thenReturn(Collections.singletonList(person));
        PersonController controller = new PersonController(service);
        List<Person> result = controller.getAll();
        assertEquals(1, result.size());
        assertSame(person, result.get(0));
    }

    @Test
    void savePerson() throws URISyntaxException {
        PersonService service = mock(PersonService.class);
        Person person = new Person("Jack","Bauer",56,"Head of CTU");
        when(service.save(person)).thenReturn(1234);
        PersonController controller = new PersonController(service);
        ResponseEntity<Void> result = controller.save(person);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(new URI("/persons/1234"), result.getHeaders().getLocation());
    }
}