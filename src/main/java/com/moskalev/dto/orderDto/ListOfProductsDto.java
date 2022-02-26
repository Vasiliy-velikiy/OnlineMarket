package com.moskalev.dto.orderDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@AllArgsConstructor(access = PRIVATE)
public class ListOfProductsDto {
    List<Integer> productsId;

    Integer orderId;
}
