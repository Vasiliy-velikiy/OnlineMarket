package com.moskalev.service;

import com.moskalev.dto.orderDto.ListOfProductsDto;
import com.moskalev.dto.orderDto.OneProductToAddInOrderDto;
import com.moskalev.dto.orderDto.OrderDto;
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
     * @param orderDto -order that we want to create
     */
     void create(OrderDto orderDto);

    /**
     * @param id -order that we want to delete
     */
     void delete(Integer id);

    /**
     * @param orderDto -order with product that we want to create
     */
     void addOrderAndProducts(OneProductToAddInOrderDto orderDto);

    /**
     * @param listOfProductsDto-order with list of products that we want to create
     */
     void addListOfProducts(ListOfProductsDto listOfProductsDto);
}
