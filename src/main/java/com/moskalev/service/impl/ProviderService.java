package com.moskalev.service.impl;

import com.moskalev.entities.Provider;
import com.moskalev.exeptions.ResourseNotFoundExeption;
import com.moskalev.repositories.ProviderRepository;

import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

/**@version  1.1
 *  @author Vasiliy Moskalev
 * @since 05.02.22
 * Class service for provider which provides interaction with providerRepository  */
@Service
public class ProviderService  {
    private ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    /**@return list of all Providers in table provider*/
    public List<Provider> readAll() {
        return providerRepository.findAll();
    }

    /**@param providerName- certain providername that is unique
     * @return certain Provider by article
     * @throws ResourseNotFoundExeption if  Product not found*/
    public Provider read(String providerName) {
        Optional<Provider> providerOptional = providerRepository.findByProviderName(providerName);
        if (providerOptional.isPresent()){
            return providerOptional.get();
        }
        else throw new ResourseNotFoundExeption(String.format("Provider with id %s not found",providerName));

    }

    /**@param provider provider class that we want to create
     *   */
    public void create(Provider provider) {
        providerRepository.save(provider);

    }

//    /**@param nameProvider -certain providerName that is unique
//     *  @throws ResourseNotFoundExeption if  Product not found*/
//    public void delete(String nameProvider) {
//     Optional<Provider>providerOptional=providerRepository.findByProviderName(nameProvider);
//        if(providerOptional.isPresent()){
//            Provider provider=providerOptional.get();
//            providerRepository.delete(provider);
//
//        }else throw new ResourseNotFoundExeption("Provider not found");
//    }

//    /**@param providerName -certain providerName that is unique
//     * @param newProvider -new Provider that we want to put in database
//     * @throws ResourseNotFoundExeption if Provider not found*/
//    public void update(String providerName, Provider newProvider) {
//        Optional<Provider>optionalProvider=providerRepository.findByProviderName(providerName);
//        if(optionalProvider.isPresent()){
//            Provider provider=optionalProvider.get();
//            provider.setProviderName(newProvider.getProviderName());
//            provider.setLegalAddress(newProvider.getLegalAddress());
//            provider.setTelefonNumber(newProvider.getTelefonNumber());
//            providerRepository.saveAndFlush(provider);
//        } else throw new ResourseNotFoundExeption("Provider not found");
//
//    }
}

