package com.moskalev.service.impl;

import com.moskalev.dto.Impl.ProviderToCreateDto;
import com.moskalev.dto.Impl.ProviderToUpdateDto;
import com.moskalev.entities.Provider;
import com.moskalev.mapper.ProviderMapper;
import com.moskalev.repositories.ProviderRepository;

import com.moskalev.service.ProviderService;
import org.hibernate.Hibernate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.ProviderException;
import java.util.Optional;
import java.util.List;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 05.02.22
 * Class service for provider which provides interaction with providerRepository
 */
@Service
public class ProviderServiceImpl implements ProviderService {
    private ProviderRepository providerRepository;

    /**
     * filed describes object for convert
     */
    private final ProviderMapper objectMapper;

    public ProviderServiceImpl(ProviderRepository providerRepository, ProviderMapper objectMapper) {
        this.providerRepository = providerRepository;
        this.objectMapper = objectMapper;
    }

    /**
     * @return page of all Providers in table provider
     */
    public Page<Provider> readAll() {
        List<Provider> listProviders = providerRepository.findAll();
        for (Provider providerOptional : listProviders) {
            Hibernate.initialize(providerOptional);
            Hibernate.initialize(providerOptional.getProductsOfProvider());
        }
        Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
        return new PageImpl<>(listProviders, firstPageWithTwoElements, listProviders.size());
    }

    /**
     * @param providerName- certain providername that is unique
     * @return certain Provider by article
     * @throws ProviderException if  Product not found
     */
    public Provider read(String providerName) {
        Optional<Provider> providerOptional = providerRepository.findByProviderName(providerName);
        if (providerOptional.isPresent()) {
            Provider provider = providerOptional.get();
            Hibernate.initialize(provider);
            Hibernate.initialize(provider.getProductsOfProvider());
            return provider;
        } else {throw new ProviderException(String.format("Provider with id %s not found", providerName));}
    }

    /**
     * @param provider provider class that we want to create
     * @throws ProviderException if Provider already exists
     */
    public void create(ProviderToCreateDto provider) {
        Optional<Provider> templateProvider = providerRepository.findByProviderName(provider.getProviderName());
        if (!templateProvider.isPresent()) {
            Provider newProvider = objectMapper.fromDto(provider);
            providerRepository.save(newProvider);
        } else {
            throw new ProviderException(String.format("Provider with name:  %s already exists", provider.getProviderName()));
        }
    }

    /**
     * @param id -certain provider id that is unique
     * @throws ProviderException if  Product not found
     */
    public void delete(Integer id) {
        Optional<Provider> providerOptional = providerRepository.findById(id);
        if (providerOptional.isPresent()) {
            Provider provider = providerOptional.get();
            providerRepository.delete(provider);
        } else {
            throw new ProviderException("Provider not found");
        }
    }

    /**
     * @param id          -certain provider id that is unique
     * @param newProvider -new Provider that we want to put in database
     * @throws ProviderException if Provider not found
     */
    public void update(Integer id, ProviderToUpdateDto newProvider) {
        Optional<Provider> providerOptional = providerRepository.findById(id);
        if (providerOptional.isPresent()) {
            Provider target = providerOptional.get();
            Provider source = objectMapper.fromUpdateDto(newProvider);
            providerRepository.save(objectMapper.merge(target, source));
        } else {
            throw new ProviderException("Product not found");
        }
    }
}

