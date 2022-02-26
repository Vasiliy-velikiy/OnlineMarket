package com.moskalev.repositories;

import com.moskalev.entities.Order;
import com.moskalev.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
