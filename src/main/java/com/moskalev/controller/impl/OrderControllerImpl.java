package com.moskalev.controller.impl;

import com.moskalev.controller.OrderController;
import com.moskalev.dto.orderDto.OneProductToAddInOrderDto;
import com.moskalev.dto.orderDto.ListOfProductsDto;
import com.moskalev.dto.orderDto.OrderDto;
import com.moskalev.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 25.02.22
 * Class controller for handling requests to buy products
 */
@RestController
@RequestMapping(path = "/api/order")
@Tag(name = "Order", description = "this is order controller")
@ApiResponse(responseCode = "500", description = "Internal error")
@ApiResponse(responseCode = "400", description = "Validation failed")
@ApiResponse(responseCode = "404", description = "Order not found")
public class OrderControllerImpl implements OrderController {
    private final OrderService orderService;

    public OrderControllerImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * @param orderDto -order that we want to create
     */
    @Operation(description = "Create order")
    @ApiResponse(responseCode = "200", description = "Order successfully created")
    @ApiResponse(responseCode = "500", description = "Order already exists")
    @PostMapping(path = "/create")
    public void create(@RequestBody OrderDto orderDto) {
        orderService.create(orderDto);
    }

    /**
     * @param id -order that we want to delete
     */
    @Operation(description = "Delete user by id")
    @ApiResponse(responseCode = "204", description = "order successfully deleted")
    @ApiResponse(responseCode = "404", description = "order not found")
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id) {
        orderService.delete(id);
    }

    /**
     * @param oneProductToAddInOrderDto -order with product that we want to create
     */
    @Operation(description = "Create order")
    @ApiResponse(responseCode = "200", description = "Order successfully created")
    @ApiResponse(responseCode = "500", description = "Order already exists")
    @PostMapping(path = "/addOrderAndProducts")
    public void addOrderAndProducts(@RequestBody OneProductToAddInOrderDto oneProductToAddInOrderDto) {
        orderService.addOrderAndProducts(oneProductToAddInOrderDto);
    }

    /**
     * @param listOfProductsDto -order with list of product that we want to create
     */
    @Operation(description = "Create order")
    @ApiResponse(responseCode = "200", description = "Order successfully created")
    @ApiResponse(responseCode = "500", description = "Order already exists")
    @PostMapping(path = "/addListOfProducts")
    public void addOListOfProducts(@RequestBody ListOfProductsDto listOfProductsDto) {
        orderService.addListOfProducts(listOfProductsDto);
    }
}
