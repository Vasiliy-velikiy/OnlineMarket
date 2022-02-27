package com.moskalev.dto.orderDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 25.02.22
 * Class dto for transfer  id of certain product and id if certain order
 */
@Getter
@Setter
@AllArgsConstructor(access = PRIVATE)
@Schema(name = "Info about one product in order", description = "Info about of certain product and certain order")
public class OneProductToAddInOrderDto {

    @Schema(description = "productId")
    Integer productId;

    @Schema(description = "orderId")
    Integer orderId;
}
