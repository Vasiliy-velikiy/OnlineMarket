package com.moskalev.dto.orderDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 25.02.22
 * Class dto for transfer list id of certain product and id if certain order
 */
@Getter
@Setter
@AllArgsConstructor(access = PRIVATE)
@Schema(name = "ListOfProducts", description = "Info about of certain list of product and certain order")
public class ListOfProductsDto {

    @Schema(description = "productsId")
    List<Integer> productsId;

    @Schema(description = "orderId")
    Integer orderId;
}
