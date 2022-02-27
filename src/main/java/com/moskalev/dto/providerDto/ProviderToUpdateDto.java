package com.moskalev.dto.providerDto;

import com.moskalev.validation.annotaton.PhoneNumber;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

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
@Schema(name = "ProviderUpdateInfo", description = "Info about product to update")
public class ProviderToUpdateDto {

    @Schema(description = "provider name")
    private String providerName;

    @Schema(description = "legal address")
    private String legalAddress;

    @Schema(description = "phone number")
    @PhoneNumber
    private String phoneNumber;
}
