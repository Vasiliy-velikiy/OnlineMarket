package com.moskalev.dto.orderDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@AllArgsConstructor(access = PRIVATE)
public class AddnewOrderAndNewProduct {
    Integer productId;
    Integer orderId;
}
