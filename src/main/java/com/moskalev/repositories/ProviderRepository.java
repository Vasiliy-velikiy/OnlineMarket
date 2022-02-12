package com.moskalev.repositories;

import com.moskalev.entities.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProviderRepository  extends JpaRepository<Provider,Integer> {
    Optional<Provider>findByProviderName(String name);
    void deleteByProviderName(String name);
}
