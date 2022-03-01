package com.moskalev.service;


import com.moskalev.dto.providerDto.ProviderDto;
import com.moskalev.dto.providerDto.ProviderToCreateDto;
import org.springframework.data.domain.Page;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 04.02.22
 * Class interface for ProviderServiceImpl
 */
public interface ProviderService {

    /**
     * @return page of all Providers in table provider
     */
    Page<ProviderDto> readAll();

    /**
     * @param providerName- certain providername that is unique
     * @return certain Provider by article
     */
    ProviderDto read(String providerName);

    /**
     * @param provider provider class that we want to create
     */
    void create(ProviderToCreateDto provider);


    /**
     * @param id -certain provider id that is unique
     */
    void delete(Integer id);

    /**
     * @param id          -certain provider id that is unique
     * @param newProvider -new Provider that we want to put in database
     */
    void update(Integer id, ProviderDto newProvider);
}
