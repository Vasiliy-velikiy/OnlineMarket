package com.moskalev.dto.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import static lombok.AccessLevel.PRIVATE;

@Value
@Builder
@AllArgsConstructor(access=PRIVATE)
public class SignUpRequest {
    String username;
    String password;
}
