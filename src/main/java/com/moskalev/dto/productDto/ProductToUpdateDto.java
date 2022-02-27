package com.moskalev.dto.productDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import javax.validation.constraints.Size;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 24.02.22
 * Class  for transfer product data for update in Database
 */
@Value
@Getter
@Setter
@AllArgsConstructor(access = PRIVATE)
@Schema(name = "ProductUpdateInfo", description = "Info about product")
public class ProductToUpdateDto {
    @Schema(description = "product name")
    @Size(max = 300)
    String productName;

    @Schema(description = "purchase price")
    Double purchasePrice;

    @Schema(description = "purchase id")
    Integer providerId;

    @Schema(description = "description")
    String description;

    @Schema(description = "article code")
    String articleCode;
}
