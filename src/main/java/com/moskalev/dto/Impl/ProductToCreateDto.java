package com.moskalev.dto.Impl;

import com.moskalev.entities.Provider;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static lombok.AccessLevel.PRIVATE;

/** @version  1.1
 * @author Vasiliy  Moskalev
 * @since 24.02.22
 * Class  for transfer product data for create in Database*/
@AllArgsConstructor(access = PRIVATE)
@Getter
@Setter
@Schema(name = "ProductCreateInfo",description = "Info about product")
public class ProductToCreateDto {

    @Schema(description = "product name", required = true)
    @NotBlank
    @Size(max = 300)
    String productName;

    @Schema(description = "purchase price", required = true)
    @NotBlank
    Double purchasePrice;

    @Schema(description = "provider id", required = true)
    private Integer providerId;

    @Schema(description = "description", required = true)
    private String description;

    @Schema(description = "article code", required = true)
    @NotBlank
    private String articleCode;


}
