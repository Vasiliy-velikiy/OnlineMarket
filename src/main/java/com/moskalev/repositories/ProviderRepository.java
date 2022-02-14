package com.moskalev.repositories;

import com.moskalev.entities.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/**@version  1.1
 * @author Vasiliy Moskalev
 * @since 01.02.22
 * Class repository for Provider*/
@Repository
public interface ProviderRepository  extends JpaRepository<Provider,Integer> {
    /**@param name that is unique
     * @return object of Optional for  null-safety
     *        */
    Optional<Provider>findByProviderName(String name);


}
