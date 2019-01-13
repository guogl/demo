package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class PersonService {

    private final PersonRepository repository;

    @Autowired
    public PersonService(final PersonRepository personRepository) {
        this.repository = personRepository;
    }

    public Person findById(final String id) {
        return repository.findById(id);
    }

    public List<Person> findByName(final String name) {
        return repository.findByName(name);
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public void createPerson(final Person person) {
        person.setCreatedAt(ZonedDateTime.now());
        person.setUpdatedAt(ZonedDateTime.now());
        repository.insert(person);
    }

    public void updatePerson(final Person person) {
        person.setUpdatedAt(ZonedDateTime.now());
        repository.update(person);
    }
}
