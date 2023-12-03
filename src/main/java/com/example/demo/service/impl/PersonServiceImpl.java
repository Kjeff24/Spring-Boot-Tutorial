package com.example.demo.service.impl;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonServiceImpl(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    @Override
    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        return personDao.selectPersonById(id);
    }

    @Override
    public int deletePerson(UUID id) {
        return personDao.deletePersonById(id);
    }

    @Override
    public int updatePerson(UUID id, Person newPerson) {
        return personDao.updatePersonById(id, newPerson);
    }
}
