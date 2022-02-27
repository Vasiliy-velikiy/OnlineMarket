package com.moskalev.service;


import com.moskalev.dto.providerDto.ProviderToCreateDto;
import com.moskalev.dto.providerDto.ProviderToUpdateDto;
import com.moskalev.entities.Provider;
import org.springframework.data.domain.Page;

import java.security.ProviderException;

public interface ProviderService {

    /**
     * @return page of all Providers in table provider
     */
    Page<Provider> readAll();

    /**
     * @param providerName- certain providername that is unique
     * @return certain Provider by article
     */
    Provider read(String providerName);

    /**
     * @param provider provider class that we want to create
     */
    void create(ProviderToCreateDto provider);


    /**
     * @param id -certain provider id that is unique
     * @throws ProviderException if  Product not found
     */
    void delete(Integer id);

    /**
     * @param id          -certain provider id that is unique
     * @param newProvider -new Provider that we want to put in database
     */
    void update(Integer id, ProviderToUpdateDto newProvider);
}
