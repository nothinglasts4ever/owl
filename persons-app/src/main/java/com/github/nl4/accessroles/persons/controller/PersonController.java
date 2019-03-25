package com.github.nl4.accessroles.persons.controller;

import com.github.nl4.accessroles.persons.client.AccessRolesClient;
import com.github.nl4.accessroles.persons.domain.Person;
import com.github.nl4.accessroles.persons.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/persons")
@Slf4j
public class PersonController {

    private final PersonService personService;
    private final AccessRolesClient accessRolesClient;

    @Autowired
    public PersonController(PersonService personService, AccessRolesClient accessRolesClient) {
        this.personService = personService;
        this.accessRolesClient = accessRolesClient;
    }

    @GetMapping
    public ResponseEntity<Iterable<Person>> allPersons() {
        var persons = personService.allPersons();
        return ResponseEntity.ok(persons);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable String id) {
        var person = personService.getPerson(id);
        return ResponseEntity.ok(person);
    }

    @PostMapping
    public ResponseEntity<Void> createPerson(@RequestBody Person person, HttpServletRequest request) {
        var createdPerson = personService.createPerson(person);
        var uri = ServletUriComponentsBuilder
                .fromContextPath(request)
                .path("/persons/{id}")
                .buildAndExpand(createdPerson.getId())
                .toUri();
        log.info("Person created: " + uri);
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updatePerson(@PathVariable String id, @RequestBody Person person) {
        personService.updatePerson(person, id);
        log.info("Person with id [" + id + "] updated");
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable String id) {
        personService.deletePerson(id);
        accessRolesClient.deleteAccessRolesForPerson(id);
        log.info("Person with id [" + id + "] removed");
        return ResponseEntity.noContent().build();
    }

}