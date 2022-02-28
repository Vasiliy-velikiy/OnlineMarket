package com.moskalev.service.impl;

import com.moskalev.dto.orderDto.OneProductToAddInOrderDto;
import com.moskalev.dto.orderDto.ListOfProductsDto;
import com.moskalev.dto.orderDto.OrderDto;
import com.moskalev.entities.Order;
import com.moskalev.entities.Person;
import com.moskalev.entities.Product;
import com.moskalev.exeptions.OrderException;
import com.moskalev.mapper.OrderMapper;
import com.moskalev.repositories.OrderRepository;
import com.moskalev.repositories.PersonRepository;
import com.moskalev.repositories.ProductRepository;
import com.moskalev.service.OrderService;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 04.02.22
 * Class service for order which provides interaction with orderRepository, productRepository, personRepository
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final PersonRepository personRepository;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository, PersonRepository personRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.personRepository = personRepository;
        this.orderMapper = orderMapper;
    }

    /**
     * @param orderDto -order that we want to create
     * @throws OrderException if person not exists in persons table
     */
    @Override
    public void create(OrderDto orderDto) {
        Optional<Person> person = personRepository.findById(orderDto.getPersonId());
        if (person.isPresent()) {
            Order order = orderMapper.fromDto(orderDto);
            order.setOwner(person.get());
            orderRepository.save(order);
        } else {
            throw new OrderException("No such person");
        }
    }

    /**
     * @param id -order that we want to delete
     * @throws OrderException if Product not found in products table
     */
    @Override
    public void delete(Integer id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            orderRepository.delete(order);
        } else {
            throw new OrderException("Product not found");
        }
    }

    /**
     * @param orderDto -order with product that we want to create
     * @throws OrderException if Number of Order or number of product not found
     */
    @Override
    public void addOrderAndProducts(OneProductToAddInOrderDto orderDto) {
        Optional<Order> optionalOrder = orderRepository.findById(orderDto.getOrderId());
        Optional<Product> optionalProduct = productRepository.findById(orderDto.getProductId());
        if (optionalOrder.isPresent() && optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            Hibernate.initialize(product);
            Order order = optionalOrder.get();
            Hibernate.initialize(order);
            product.addOrder(order);
            order.addProducts(product);
        } else {
            throw new OrderException("Number of Order or number of product not found");
        }
    }

    /**
     * @param listOfProductsDto-order with list of products that we want to create
     * @throws OrderException if Number of Order or number of product not found
     */
    @Override
    public void addListOfProducts(ListOfProductsDto listOfProductsDto) {
        Optional<Order> optionalOrder = orderRepository.findById(listOfProductsDto.getOrderId());
        List<Integer> productsIdList = listOfProductsDto.getProductsId();
        for (Integer productId : productsIdList) {
            Optional<Product> optionalProduct = productRepository.findById(productId);
            if (optionalOrder.isPresent() && optionalProduct.isPresent()) {
                Product product = optionalProduct.get();
                Hibernate.initialize(product);
                Order order = optionalOrder.get();
                Hibernate.initialize(order);
                product.addOrder(order);
                order.addProducts(product);
            } else {
                throw new OrderException("Number of Order or number of product not found");
            }
        }
    }
}
