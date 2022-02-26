package com.moskalev.controller.impl;

import com.moskalev.dto.orderDto.AddnewOrderAndNewProduct;
import com.moskalev.dto.orderDto.OrderDto;
import com.moskalev.service.impl.OrderServiceImpl;
import org.springframework.web.bind.annotation.*;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 25.02.22
 * Class controller for handling requests to buy products
 */
@RestController
@RequestMapping(path = "/api/order")
public class OrderController {

    private final OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = "/create")
    public void create(@RequestBody OrderDto orderDto){
        orderService.create(orderDto);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id) {
        orderService.delete(id);
    }


    @PostMapping(path = "/addOrderAndProducts")
    public void addOrderAndProducts(@RequestBody AddnewOrderAndNewProduct addnewOrderAndNewProduct){
        orderService.addOrderAndProducts(addnewOrderAndNewProduct);
    }

}
