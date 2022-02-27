package com.moskalev.dto.personDto;

import com.moskalev.entities.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.extern.jackson.Jacksonized;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 09.02.22
 * Class  for transfer user data for create in Database
 */
@AllArgsConstructor(access = PRIVATE)
@Getter
@Setter
@Builder
@Jacksonized
@Schema(name = "PersonCreateInfo", description = "Info about person to create")
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

    @Schema(description = "role", required = true)
    @NotNull
    private Role role;
}
