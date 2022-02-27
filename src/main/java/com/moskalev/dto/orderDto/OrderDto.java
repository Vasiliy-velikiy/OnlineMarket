package com.moskalev.dto.orderDto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 25.02.22
 * Class dto for transfer id of certain person
 */
@Getter
@Setter
@Value
@Builder
@Jacksonized
@AllArgsConstructor(access = PRIVATE)
@Schema(name = "info about order", description = "Info about of certain order and certain owner")
public class OrderDto {

    @Schema(description = "productId")
    private Integer personId;
}
