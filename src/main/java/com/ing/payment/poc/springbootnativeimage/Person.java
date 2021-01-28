package com.ing.payment.poc.springbootnativeimage;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Value
public class Person {

    private String firstName;
    private String lastName;
    private int age;
}
