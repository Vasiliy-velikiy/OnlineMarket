package com.moskalev.service.impl;

import com.moskalev.dto.orderDto.AddnewOrderAndNewProduct;
import com.moskalev.dto.orderDto.ListOfProductsDto;
import com.moskalev.dto.orderDto.OrderDto;
import com.moskalev.entities.Order;
import com.moskalev.entities.Person;
import com.moskalev.entities.Product;
import com.moskalev.entities.Provider;
import com.moskalev.exeptions.OrderExeption;
import com.moskalev.exeptions.ProductException;
import com.moskalev.mapper.OrderMapper;
import com.moskalev.repositories.OrderRepository;
import com.moskalev.repositories.PersonRepository;
import com.moskalev.repositories.ProductRepository;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl {
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

    public void create(OrderDto orderDto){
            Optional<Person> person = personRepository.findById(orderDto.getPersonId());
        System.out.println(person);
            if (person.isPresent()) {
                Order order = orderMapper.fromDto(orderDto);
                order.setOwner(person.get());
       System.out.println(order.getOwner().getId());
                orderRepository.save(order);
            } else {
                throw new OrderExeption("No such person");
            }
        }

    public void delete(Integer id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
           orderRepository.delete(order);
        } else {
            throw new OrderExeption("Product not found");
        }
    }


    public void addOrderAndProducts(AddnewOrderAndNewProduct orderDto) {
        Optional<Order> optionalOrder = orderRepository.findById(orderDto.getOrderId());
        Optional<Product> optionalProduct = productRepository.findById(orderDto.getProductId());
        if (optionalOrder.isPresent() && optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            Hibernate.initialize(product);
            Order order = optionalOrder.get();
            Hibernate.initialize(order);
            product.addOrder(order);
            order.addProducts(product);
        }
        else{
            throw new OrderExeption("Number of Order or number of product not found");
        }
    }


    public void addListOfProducts(ListOfProductsDto listOfProductsDto){
        Optional<Order> optionalOrder = orderRepository.findById(listOfProductsDto.getOrderId());
        List<Integer>productsIdList=listOfProductsDto.getProductsId();
        for (Integer productId:productsIdList){
            Optional<Product> optionalProduct = productRepository.findById(productId);
            if (optionalOrder.isPresent() && optionalProduct.isPresent()) {
                Product product = optionalProduct.get();
                Hibernate.initialize(product);
                Order order = optionalOrder.get();
                Hibernate.initialize(order);
                product.addOrder(order);
                order.addProducts(product);
            }
            else{
                throw new OrderExeption("Number of Order or number of product not found");
            }
        }
    }
}
