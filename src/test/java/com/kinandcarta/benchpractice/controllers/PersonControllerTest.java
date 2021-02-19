package com.kinandcarta.benchpractice.controllers;

import com.kinandcarta.benchpractice.models.Person;
import com.kinandcarta.benchpractice.services.PersonService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PersonControllerTest {

    @Test
    void getAll() {
        PersonService service = mock(PersonService.class);
        Person person = new Person();
        when(service.getAll()).thenReturn(Arrays.asList(person));
        PersonController controller = new PersonController(service);
        List<Person> result = controller.getAll();
        assertEquals(1, result.size());
        assertSame(person, result.get(0));
    }
}