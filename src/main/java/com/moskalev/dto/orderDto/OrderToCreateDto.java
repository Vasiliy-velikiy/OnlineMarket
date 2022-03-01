package com.moskalev.dto.orderDto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 25.02.22
 * Class dto for transfer id of certain person
 */
@Getter
@Setter
@Schema(name = "info about order", description = "Info about of certain order and certain owner")
public class OrderToCreateDto {

    @Schema(description = "productId")
    private Integer personId;
}
