package com.moskalev.dto.personDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 25.02.22
 * Class  for transfer user data for sign in
 */
@AllArgsConstructor(access = PRIVATE)
@Getter
@Setter
@Value
@Builder
@Jacksonized
@Schema(name = "PersonSignIn", description = "Info about person to sign in")
public class PersonSignInDto {

    @Schema(description = "email", required = true)
    @NotBlank
    @Email
    @Size(max = 30)
    private String email;

    @Schema(description = "password", required = true)
    @NotBlank
    @Size(min = 7, max = 300)
    private String password;
}
