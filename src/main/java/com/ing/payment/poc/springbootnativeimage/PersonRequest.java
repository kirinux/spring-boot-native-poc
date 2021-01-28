package com.ing.payment.poc.springbootnativeimage;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
public class PersonRequest {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Positive
    private int age;

}
