package com.moskalev.repositories;

import com.moskalev.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product>findByArticleCode(String articleCode);
    void deleteById(String id);
}
