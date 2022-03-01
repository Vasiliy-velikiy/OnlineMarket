package com.moskalev.dto.productDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 24.02.22
 * Class  for transfer product data for create in Database
 */
@AllArgsConstructor(access = PRIVATE)
@Getter
@Setter
@Value
@Builder
@Jacksonized
@Schema(name = "ProductCreateInfo", description = "Info about product")
public class ProductToCreateDto {

    @Schema(description = "product name", required = true)
    @NotBlank
    @Size(max = 300)
    String productName;

    @Schema(description = "purchase price", required = true)
    @NotBlank
    Double purchasePrice;

    @Schema(description = "provider name", required = true)
    private String providerName;

    @Schema(description = "description", required = true)
    private String description;

    @Schema(description = "article code", required = true)
    @NotBlank
    private String articleCode;
}
