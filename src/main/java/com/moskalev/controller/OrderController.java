package com.moskalev.controller;

import com.moskalev.dto.orderDto.ListOfProductsDto;
import com.moskalev.dto.orderDto.OneProductToAddInOrderDto;
import com.moskalev.dto.orderDto.OrderDto;


/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 25.02.22
 * Class interface for handling requests to buy products
 */
public interface OrderController {

    /**
     * @param orderDto -order that we want to create
     */
    void create(OrderDto orderDto);

    /**
     * @param id -order that we want to delete
     */
    void delete(Integer id);

    /**
     * @param oneProductToAddInOrderDto -order with product that we want to create
     */
    void addOrderAndProducts(OneProductToAddInOrderDto oneProductToAddInOrderDto);

    /**
     * @param listOfProductsDto -order with list of product that we want to create
     */
    void addOListOfProducts(ListOfProductsDto listOfProductsDto);
}
