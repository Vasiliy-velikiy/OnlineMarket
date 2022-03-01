package com.moskalev.service.impl;


import com.moskalev.dto.providerDto.ProviderDto;
import com.moskalev.dto.providerDto.ProviderToCreateDto;
import com.moskalev.entities.Provider;
import com.moskalev.exeptions.ProviderException;
import com.moskalev.mapper.MergeProviderMapper;
import com.moskalev.mapper.impl.ProviderMapper;
import com.moskalev.repositories.ProviderRepository;

import com.moskalev.service.ProviderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 05.02.22
 * Class service for provider which provides interaction with providerRepository
 */
@Service
@Transactional
public class ProviderServiceImpl implements ProviderService {

    private ProviderRepository providerRepository;

    private final MergeProviderMapper objectMapper;

    private final ProviderMapper providerMapper;

    public ProviderServiceImpl(ProviderRepository providerRepository, MergeProviderMapper objectMapper, ProviderMapper providerMapper) {
        this.providerRepository = providerRepository;
        this.objectMapper = objectMapper;
        this.providerMapper = providerMapper;
    }

    /**
     * @return page of all Providers from table provider
     */
    public Page<ProviderDto> readAll() {
        List<ProviderDto> listProviders = providerMapper.convertListToDto(providerRepository.findAll());
        Pageable firstPageWithTwoElements = PageRequest.of(0, listProviders.size());
        return new PageImpl<>(listProviders, firstPageWithTwoElements, listProviders.size());
    }

    /**
     * @param providerName- certain providername that is unique
     * @return certain Provider by article
     * @throws ProviderException if  Product not found
     */
    public ProviderDto read(String providerName) {
        Optional<Provider> providerOptional = providerRepository.findByProviderName(providerName);
        if (providerOptional.isPresent()) {
            return providerMapper.toDto(providerOptional.get());
        } else {
            throw new ProviderException(String.format("Provider with id %s not found", providerName));
        }
    }

    /**
     * @param provider provider class that we want to create
     * @throws ProviderException if Provider already exists
     */
    public void create(ProviderToCreateDto provider) {
        Optional<Provider> templateProvider = providerRepository.findByProviderName(provider.getProviderName());
        if (!templateProvider.isPresent()) {
            Provider newProvider = providerMapper.fromCreateDto(provider);
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
    public void update(Integer id, ProviderDto newProvider) {
        Optional<Provider> providerOptional = providerRepository.findById(id);
        if (providerOptional.isPresent()) {
            Provider target = providerOptional.get();
            Provider source = providerMapper.fromDto(newProvider);
            providerRepository.save(objectMapper.merge(target, source));
        } else {
            throw new ProviderException("Product not found");
        }
    }
}

