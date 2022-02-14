package com.moskalev.repositories;

import com.moskalev.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/**@version  1.1
 * @author Vasiliy  Moskalev
 * @since 01.02.22
 * Class repository for Prodoct*/

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    /**@param articleCode that is unique
     * @return object of Optional for  null-safety
     *        */
    Optional<Product>findByArticleCode(String articleCode);

}
