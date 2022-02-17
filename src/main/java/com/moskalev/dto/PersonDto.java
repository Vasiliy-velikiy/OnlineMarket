package com.moskalev.dto;


import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(name = "PersonInfo",description = "Info about person")
public class PersonDto {

    @Schema(description = "first name", required = true)
    @NotBlank
    @Size(max = 300)
    private String firstName;

    @Schema(description = "last name", required = true)
    @NotBlank
    @Size(max = 300)
    private String lastName;

    @Schema(description = "email", required = true)
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
