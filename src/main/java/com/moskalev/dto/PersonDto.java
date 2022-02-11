package com.moskalev.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDto {

    private String firstName;
    private String lastName;
    private String email;

    public PersonDto() {

    }

    public PersonDto(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
