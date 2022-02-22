package com.moskalev.dto.impl;


import com.moskalev.entities.Role;
import com.moskalev.validation.annotaton.Email;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/** @version  1.1
 * @author Vasiliy  Moskalev
 * @since 09.02.22
 * Class  for transfer user data for create in Database*/
@Getter
@Setter
@Schema(name = "PersonInfo",description = "Info about person")
public class PersonToCreateDto {

    @Schema(description = "first name", required = true)
    @NotBlank
    @Size(max = 300)
    private String firstName;

    @Schema(description = "last name", required = true)
    @NotBlank
    @Size(max = 300)
    private String lastName;

    @Schema(description = "email", required = true)
    @NotBlank
    @Email
    @Size(max = 30)
    private String email;

    @Schema(description = "password", required = true)
    @NotBlank
    @Size(min = 7, max = 300)
    private String password;

    @Schema(description = "password", required = true)
    @NotNull
    private Role role;

}
