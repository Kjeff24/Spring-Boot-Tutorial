package com.example.demo.service;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonService {
    int addPerson(Person person);

    List<Person> getAllPeople();

    Optional<Person> getPersonById(UUID id);

    int deletePerson(UUID id);

    int updatePerson(UUID id, Person newPerson);
}
