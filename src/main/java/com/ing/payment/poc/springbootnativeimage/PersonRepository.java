package com.ing.payment.poc.springbootnativeimage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonRepository.class);

    public boolean addPerson(Person person) {
        LOGGER.info("repository add person {}", person);

        return true;
    }

}
