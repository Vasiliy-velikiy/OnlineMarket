package com.moskalev.repositories;

import com.moskalev.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 01.02.22
 * Class repository for Product
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    /**
     * @param articleCode that is unique
     * @return object of Optional for  null-safety
     */
    Optional<Product> findByArticleCode(String articleCode);
}
