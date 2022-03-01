package com.moskalev.service;

import com.moskalev.dto.orderDto.ListOfProductsDto;
import com.moskalev.dto.orderDto.OneProductInOrderDto;
import com.moskalev.dto.orderDto.OrderToCreateDto;
import org.springframework.stereotype.Service;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 25.02.22
 * Class service for handling requests to buy products
 */
@Service
public interface OrderService {

    /**
     * @param orderToCreateDto -order that we want to create
     */
    void create(OrderToCreateDto orderToCreateDto);

    /**
     * @param id -order that we want to delete
     */
    void delete(Integer id);

    /**
     * @param orderDto -order with product that we want to create
     */
     void addProductInOrder(OneProductInOrderDto orderDto);

    /**
     * @param listOfProductsDto-order with list of products that we want to create
     */
     void addListOfProducts(ListOfProductsDto listOfProductsDto);
}
