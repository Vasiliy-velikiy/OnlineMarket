package com.moskalev.controller.impl;

import com.moskalev.entities.Provider;
import com.moskalev.service.impl.ProviderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @version 1.1
 *  * @author Vasiliy Moskalev
 * Class controller for handling requests to providerrepository through the providerservice */
@RestController
@RequestMapping(path = "/api/provider")
public class ProviderController   {
    private ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

/**@param providerName -certain name that is unique
 * @return -certain provider that we want to get */
    @RequestMapping(path = "/read/{providerName}")
    public Provider read(@PathVariable String providerName) {
        return providerService.read(providerName);
    }

    /**
     * @return list of Providers*/
    @RequestMapping(path = "/readAll")
    public List<Provider> readAll() {
        return providerService.readAll();
    }

    /**@param provider -object that we want to create*/
    @PostMapping(path = "/create")
    public void create(@RequestBody Provider provider) {
        providerService.create(provider);

    }
    /**@param nameProvider  -object that we want to delete*/
    @DeleteMapping(path = "/{nameProvider}")
    public void delete(@PathVariable String nameProvider) {
        providerService.delete(nameProvider);

    }
    /**@param providerName  -certain name that is unique
     * @param newProvider-object that we want to update*/
   @PutMapping(path = "/{providerName}")
    public void update(@PathVariable String providerName, @RequestBody Provider newProvider) {
        providerService.update(providerName, newProvider);
    }
}
