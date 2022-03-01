package com.moskalev.dto.productDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.Size;

/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 24.02.22
 * Class  for transfer product data for update in Database or to get data about person
 */
@Getter
@Setter
@RequiredArgsConstructor
@Schema(name = "ProductUpdateInfo", description = "Info about product")
public class ProductDto {

    @Schema(description = "product name")
    @Size(max = 300)
    String productName;

    @Schema(description = "purchase price")
    Double purchasePrice;

    @Schema(description = "purchase name")
    String  providerName;

    @Schema(description = "description")
    String description;

    @Schema(description = "article code")
    String articleCode;

}
