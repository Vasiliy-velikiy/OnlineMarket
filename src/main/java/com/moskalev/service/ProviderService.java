package com.moskalev.service;

import com.moskalev.entities.Person;
import com.moskalev.entities.Product;
import com.moskalev.entities.Provider;
import com.moskalev.exeptions.ResourseNotFoundExeption;
import com.moskalev.repositories.ProviderRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;


@Service
//@RequiredArgsConstructor
public class ProviderService  {
    private ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }



    public List<Provider> readAll() {
        return providerRepository.findAll();
    }


    public Provider read(String t) {
        Optional<Provider> providerOptional = providerRepository.findById(Integer.valueOf(t));
        if (providerOptional.isPresent()){
            return providerOptional.get();
        }
        else throw new ResourseNotFoundExeption(String.format("Provider with id %s not found",t));

    }


    public void create(Provider provider) {
        providerRepository.save(provider);

    }


    public void delete(String nameProvider) {
     Optional<Provider>providerOptional=providerRepository.findByProviderName(nameProvider);
        if(providerOptional.isPresent()){
            Provider provider=providerOptional.get();
            providerRepository.delete(provider);

        }else throw new ResourseNotFoundExeption("Provider not found");
    }


    public void update(String providerName, Provider newProvider) {
        Optional<Provider>optionalProvider=providerRepository.findByProviderName(providerName);
        if(optionalProvider.isPresent()){
            Provider provider=optionalProvider.get();
            provider.setProviderName(newProvider.getProviderName());
            provider.setLegalAddress(newProvider.getLegalAddress());
            provider.setTelefonNumber(newProvider.getTelefonNumber());
            providerRepository.saveAndFlush(provider);
        } else throw new ResourseNotFoundExeption("Provider not found");

    }
}

