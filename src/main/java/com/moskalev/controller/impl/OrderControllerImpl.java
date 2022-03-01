package com.moskalev.controller.impl;

import com.moskalev.controller.OrderController;
import com.moskalev.dto.orderDto.ListOfProductsDto;
import com.moskalev.dto.orderDto.OneProductInOrderDto;
import com.moskalev.dto.orderDto.OrderToCreateDto;
import com.moskalev.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 25.02.22
 * Class controller for handling requests to buy products
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/order")
@Tag(name = "Order", description = "this is order controller")
@ApiResponse(responseCode = "500", description = "Internal error")
@ApiResponse(responseCode = "400", description = "Validation failed")
@ApiResponse(responseCode = "404", description = "Order not found")
public class OrderControllerImpl implements OrderController {

    private final OrderService orderService;

    /**
     * @param orderToCreateDto -order that we want to create
     */
    @Operation(description = "Create order")
    @ApiResponse(responseCode = "200", description = "Order successfully created")
    @ApiResponse(responseCode = "500", description = "Order already exists")
    @PostMapping(path = "/create")
    @PreAuthorize("hasRole('CUSTOMER') || hasAuthority('ROLE_CUSTOMER') || hasRole('ADMIN') || hasAuthority('ROLE_ADMIN')" )
    public void create(@RequestBody OrderToCreateDto orderToCreateDto) {
        orderService.create(orderToCreateDto);
    }

    /**
     * @param id -order that we want to delete
     */
    @Operation(description = "Delete user by id")
    @ApiResponse(responseCode = "204", description = "order successfully deleted")
    @ApiResponse(responseCode = "404", description = "order not found")
    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasRole('CUSTOMER') || hasAuthority('ROLE_CUSTOMER')" )
    public void delete(@PathVariable Integer id) {
        orderService.delete(id);
    }

    /**
     * @param oneProductInOrderDto -order with product that we want to create
     */
    @Operation(description = "Create order")
    @ApiResponse(responseCode = "200", description = "Order successfully created")
    @ApiResponse(responseCode = "500", description = "Order already exists")
    @PostMapping(path = "/addOrderAndProducts")
    @PreAuthorize("hasRole('CUSTOMER') || hasAuthority('ROLE_CUSTOMER')" )
    public void addOrderAndProducts(@RequestBody OneProductInOrderDto oneProductInOrderDto) {
        orderService.addProductInOrder(oneProductInOrderDto);
    }

    /**
     * @param listOfProductsDto -order with list of product that we want to create
     */
    @Operation(description = "Create order")
    @ApiResponse(responseCode = "200", description = "Order successfully created")
    @ApiResponse(responseCode = "500", description = "Order already exists")
    @PostMapping(path = "/addListOfProducts")
    @PreAuthorize("hasRole('CUSTOMER') || hasAuthority('ROLE_CUSTOMER')" )
    public void addOListOfProducts(@RequestBody ListOfProductsDto listOfProductsDto) {
        orderService.addListOfProducts(listOfProductsDto);
    }
}
