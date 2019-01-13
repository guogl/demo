package com.example.demo.rest;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService service;

    @Autowired
    public PersonController(final PersonService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Person> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        service.createPerson(person);

        return service.findById(person.getId());
    }

    @PutMapping
    public Person update(@RequestBody Person person) {
        final Person original = service.findById(person.getId());
        BeanUtils.copyProperties(person, original, "createdAt", "id");
        service.updatePerson(original);
        return service.findById(original.getId());
    }
}
