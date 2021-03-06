package com.moskalev.controller;


import com.moskalev.dto.providerDto.ProviderToCreateDto;
import com.moskalev.dto.providerDto.ProviderToUpdateDto;
import com.moskalev.entities.Provider;
import org.springframework.data.domain.Page;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 25.02.22
 * interface controller for provider controller
 */
public interface ProviderController {

    /**
     * @param providerName -certain name that is unique
     * @return -certain provider that we want to get
     */
    Provider read(String providerName);

    /**
     * @return list of Providers
     */
    Page<Provider> readAll();

    /**
     * @param newProvider-object that we want to create
     */
    void create(ProviderToCreateDto newProvider);

    /**
     * @param id -object that we want to delete
     */
    void delete(Integer id);

    /**
     * @param id      -certain name that is unique
     * @param newProvider-object that we want to update
     */
    void update( Integer id, ProviderToUpdateDto newProvider);
}
