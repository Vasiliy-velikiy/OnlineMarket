package com.moskalev.controller.impl;

import com.moskalev.entities.Provider;
import com.moskalev.service.ProviderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/provider")
public class ProviderController   {
    private ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }
    @RequestMapping(path = "/read/{id}")
    public Provider read(@RequestParam String id) {
        return providerService.read(id);
    }
    @RequestMapping(path = "/readAll")
    public List<Provider> readAll() {
        return providerService.readAll();
    }

    @PostMapping(path = "/create}")
    public void create(@RequestBody Provider provider) {
        providerService.create(provider);

    }
    @DeleteMapping
    public void delete(String provider) {
        providerService.delete(provider);

    }


    public void update(Provider provider, Provider newT) {

    }
}
