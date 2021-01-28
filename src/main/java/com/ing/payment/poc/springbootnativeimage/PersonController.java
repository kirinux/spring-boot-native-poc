package com.ing.payment.poc.springbootnativeimage;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @PostMapping(value = "/person")
    public ResponseEntity<PersonResponse> addPerson(@Valid @RequestBody PersonRequest request) {
        LOGGER.info("receive person request {}", request);

        Person person = new Person(
                request.getFirstName(),
                request.getLastName(),
                request.getAge()
        );

        repository.addPerson(person);

        return ResponseEntity.ok(new PersonResponse("person added"));
    }

}
