package com.moskalev.repositories;

import com.moskalev.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 01.02.22
 * Class repository for Order
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
