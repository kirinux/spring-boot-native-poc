package com.ing.payment.poc.springbootnativeimage;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration(proxyBeanMethods = false)
public class AppConfiguration {

    @Bean
    public PersonRepository personRepository(@Qualifier("edlJdbcTemplate") NamedParameterJdbcTemplate template) {
        return new PersonRepository(template);
    }

}
