package com.moskalev.dto.Impl;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static lombok.AccessLevel.PRIVATE;

/** @version  1.1
 * @author Vasiliy  Moskalev
 * @since 25.02.22
 * Class  for transfer user data for sign in*/
@AllArgsConstructor(access = PRIVATE)
@Getter
@Setter
@Schema(name = "PersonSignIn",description = "Info about person to sign in")
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
