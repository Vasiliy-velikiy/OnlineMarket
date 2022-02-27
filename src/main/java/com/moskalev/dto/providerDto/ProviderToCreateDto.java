package com.moskalev.dto.providerDto;

import com.moskalev.validation.annotaton.PhoneNumber;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotBlank;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 24.02.22
 * Class  for transfer provider data for create in Database
 */
@AllArgsConstructor(access = PRIVATE)
@Getter
@Setter
@Value
@Builder
@Jacksonized
@Schema(name = "ProviderCreateInfo", description = "Info about product to create")
public class ProviderToCreateDto {

    @Schema(description = "provider name", required = true)
    @NotBlank
    private String providerName;

    @Schema(description = "legal address", required = true)
    @NotBlank
    private String legalAddress;

    @Schema(description = "phone number", required = true)
    @NotBlank
    @PhoneNumber
    private String phoneNumber;
}
