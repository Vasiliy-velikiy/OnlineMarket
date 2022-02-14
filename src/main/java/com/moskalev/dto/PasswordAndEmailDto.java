package com.moskalev.dto;

import lombok.Getter;
import lombok.Setter;
/**@version 1.1
 *  * @author Vasiliy Moskalev
 *  @since 09.02.22
 *  Class for pass information about personal area in server*/
@Getter
@Setter
public class PasswordAndEmailDto {

    private String email;
    private String password;

    public PasswordAndEmailDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
