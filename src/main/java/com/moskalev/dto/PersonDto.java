package com.moskalev.dto;


import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Size;


/** @version  1.1
 * @author Vasiliy  Moskalev
 * @since 09.02.22
 * Class for display information about person without password and id*/
@Getter
@Setter
public class PersonDto {
    @NotBlank
    @Size(max = 300)
    private String firstName;
    @NotBlank
    @Size(max = 300)
    private String lastName;
    @NotEmpty
    @Size(max = 30)
    private String email;

    public PersonDto() {
    }

    public PersonDto(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
