package com.moskalev.dto.orderDto;

import com.moskalev.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@AllArgsConstructor(access = PRIVATE)
public class OrderDto {

    private Integer personId;

    private List<Product> products;

}
