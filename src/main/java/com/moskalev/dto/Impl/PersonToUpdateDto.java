package com.moskalev.dto.Impl;

import com.moskalev.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import static lombok.AccessLevel.PRIVATE;
/** @version  1.1
 * @author Vasiliy  Moskalev
 * @since 09.02.22
 * Class  for transfer user data for update in Database*/
@Value
@Builder
@Jacksonized
@AllArgsConstructor(access = PRIVATE)
public class PersonToUpdateDto {
    String firstName;
    String lastName;
    String email;
    Role role;
    String password;
}
