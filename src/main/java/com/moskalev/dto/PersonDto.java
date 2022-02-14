package com.moskalev.dto;

import lombok.Getter;
import lombok.Setter;


/** @version  1.1
 * @author Vasiliy  Moskalev
 * @since 09.02.22
 * Class for display information about person without password and id*/
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
