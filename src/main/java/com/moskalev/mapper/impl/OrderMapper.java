package com.moskalev.mapper.impl;

import com.moskalev.dto.orderDto.OrderToCreateDto;
import com.moskalev.entities.Order;
import com.moskalev.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 24.02.22
 * Class mapper for conversion Order to OrderDto and back
 */
@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final PersonRepository personRepository;

    /**
     * @param source  OrderDto  object
     * @return  -Order object
     */
    public Order fromCreateDto(OrderToCreateDto source) {
        Order order=new Order();
        order.setOwner(personRepository.findById(source.getPersonId()).get());
        return order;
    }
}
