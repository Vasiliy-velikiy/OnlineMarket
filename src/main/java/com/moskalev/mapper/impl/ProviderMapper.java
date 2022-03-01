package com.moskalev.mapper.impl;

import com.moskalev.dto.providerDto.ProviderDto;
import com.moskalev.dto.providerDto.ProviderToCreateDto;
import com.moskalev.entities.Provider;
import com.moskalev.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 24.02.22
 * Class mapper for conversion Provider to ProviderDto and ProviderToCreateDto and back
 */
@Component
@RequiredArgsConstructor
public class ProviderMapper implements Mapper<Provider, ProviderDto> {

    /**
     * @param source -Provider object
     * @return ProviderDto object
     */
    @Override
    public ProviderDto toDto(Provider source) {
        ProviderDto providerDto=new ProviderDto();
        providerDto.setProviderName(source.getProviderName());
        providerDto.setLegalAddress(source.getLegalAddress());
        providerDto.setPhoneNumber(source.getPhoneNumber());

        if(source.getProductsOfProvider().size()!=0) {
            HashMap<String, String> nameAndArticleProducts = new HashMap<>();
            for (int i = 0; i < source.getProductsOfProvider().size(); i++) {
                nameAndArticleProducts.put(source.getProductsOfProvider().get(i).getArticleCode(), source.getProductsOfProvider().get(i).getProductName());
            }
            providerDto.setNameAndArticleProducts(nameAndArticleProducts);
        }
        return providerDto;
    }

    /**
     * @param source -ProviderDto object
     * @return Provider object
     */
    @Override
    public Provider fromDto(ProviderDto source) {
        Provider provider=new Provider();
        provider.setProviderName(source.getProviderName());
        provider.setLegalAddress(source.getLegalAddress());
        provider.setPhoneNumber(source.getPhoneNumber());
        return provider;
    }

    /**
     * @param source -ProviderToCreateDto object
     * @return Provider  object
     */
    public Provider  fromCreateDto(ProviderToCreateDto source) {
        Provider provider=new Provider();
        provider.setProviderName(source.getProviderName());
        provider.setLegalAddress(source.getLegalAddress());
        provider.setPhoneNumber(source.getPhoneNumber());
       return provider;
    }

    /**
     * @param objList -List of Provider object
     * @return List of ProviderDto object
     */
    @Override
    public List<ProviderDto> convertListToDto(List<Provider> objList) {
        List<ProviderDto> providerDtoList = new ArrayList<>();
        for (Provider provider : objList) {
            providerDtoList.add(toDto(provider));
        }
        return providerDtoList;
    }
}
