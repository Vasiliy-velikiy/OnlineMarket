package com.moskalev.dto.providerDto;

import com.moskalev.validation.annotaton.PhoneNumber;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.HashMap;

/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 24.02.22
 * Class  for transfer provider data for create in Database
 */
@RequiredArgsConstructor
@Getter
@Setter
@Schema(name = "ProviderUpdateInfo", description = "Info about product to update")
public class ProviderDto {

    @Schema(description = "provider name")
    private String providerName;

    @Schema(description = "legal address")
    private String legalAddress;

    @Schema(description = "phone number")
    @PhoneNumber
    private String phoneNumber;

    @Schema(description = "name And Article of Products")
    HashMap<String, String> nameAndArticleProducts;
}
