package com.moskalev.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**@version 1.1
 *  * @author Vasiliy Moskalev
 *  @since 09.02.22
 *  Class for pass information about personal area in server*/
@Getter
@Setter
public class PasswordAndEmailDto {
    @NotEmpty
    @Size(max = 30)
    private String email;
    @NotEmpty
    @Size(min = 7)
    private String password;

    public PasswordAndEmailDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
