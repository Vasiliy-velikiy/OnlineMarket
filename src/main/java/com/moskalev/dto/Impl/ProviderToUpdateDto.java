package com.moskalev.dto.Impl;

import com.moskalev.validation.annotaton.PhoneNumber;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static lombok.AccessLevel.PRIVATE;

/** @version  1.1
 * @author Vasiliy  Moskalev
 * @since 24.02.22
 * Class  for transfer provider data for create in Database*/
@AllArgsConstructor(access = PRIVATE)
@Getter
@Setter
@Schema(name = "ProviderUpdateInfo",description = "Info about product to update")
public class ProviderToUpdateDto  {

    @Schema(description = "provider name")
    private String providerName;

    @Schema(description = "legal address")
    private String legalAddress;

    @Schema(description = "phone number")
    @PhoneNumber
    private String phoneNumber;
}
