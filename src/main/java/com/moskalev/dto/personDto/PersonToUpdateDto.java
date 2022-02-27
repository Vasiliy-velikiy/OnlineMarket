package com.moskalev.dto.personDto;

import com.moskalev.entities.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 09.02.22
 * Class  for transfer user data for update in Database
 */

@Getter
@Setter
@Value
@Builder
@Jacksonized
@AllArgsConstructor(access = PRIVATE)
@Schema(name = "PersonUpdateInfo", description = "Info about person to create")
public class PersonToUpdateDto {
    @Schema(description = "first name")
    String firstName;

    @Schema(description = "last name")
    String lastName;

    @Schema(description = "email")
    @Email
    String email;

    @Schema(description = "role", required = true)
    @NotNull
    Role role;

    @Schema(description = "password")
    @Size(min = 7, max = 300)
    String password;
}
