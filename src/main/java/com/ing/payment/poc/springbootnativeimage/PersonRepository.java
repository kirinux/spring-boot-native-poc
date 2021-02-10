package com.ing.payment.poc.springbootnativeimage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

public class PersonRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonRepository.class);

    private static final String SQL_SELECT_PERSONID = "select FIRSTNAME, LASTNAME, BIRTHDATE from dev.person where ID = :cif";
    private final NamedParameterJdbcTemplate edlJdbcTemplate;

    public PersonRepository(NamedParameterJdbcTemplate edlJdbcTemplate) {
        this.edlJdbcTemplate = edlJdbcTemplate;
    }

    public Optional<Person> findCustomer(String cif) {
        LOGGER.debug("Check if client findCustomer for cif {}", cif);
        try {
            Person customer = edlJdbcTemplate.queryForObject(SQL_SELECT_PERSONID, new MapSqlParameterSource("cif", requireNonNull(cif)), new RowMapper<Person>() {
                @Override
                public Person mapRow(ResultSet resultSet, int i) throws SQLException {
                    String firstname = resultSet.getString("FIRSTNAME");
                    String lastname = resultSet.getString("LASTNAME");
                    LocalDate birthdate = resultSet.getDate("BIRTHDATE").toLocalDate();

                    int age = Period.between(birthdate, LocalDate.now()).getYears();
                    return new Person(firstname, lastname, age);
                }
            });
            return Optional.ofNullable(customer);
        } catch (EmptyResultDataAccessException e) {
            LOGGER.error("Cif not found {}", cif);
            return Optional.empty();
        }
    }

    public boolean addPerson(Person person) {
        LOGGER.info("repository add person {}", person);

        return true;
    }

}
