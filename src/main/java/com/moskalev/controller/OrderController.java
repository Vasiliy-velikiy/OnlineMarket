package com.moskalev.controller;


import com.moskalev.dto.orderDto.ListOfProductsDto;
import com.moskalev.dto.orderDto.OneProductInOrderDto;
import com.moskalev.dto.orderDto.OrderToCreateDto;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 25.02.22
 * Class interface for handling requests to buy products
 */
public interface OrderController {

    /**
     * @param orderToCreateDto -order that we want to create
     */
    void create(OrderToCreateDto orderToCreateDto);

    /**
     * @param id -order that we want to delete
     */
    void delete(Integer id);

    /**
     * @param oneProductInOrderDto o -order with product that we want to create
     */
    void addOrderAndProducts(OneProductInOrderDto oneProductInOrderDto);

    /**
     * @param listOfProductsDto -order with list of product that we want to create
     */
    void addOListOfProducts(ListOfProductsDto listOfProductsDto);
}
