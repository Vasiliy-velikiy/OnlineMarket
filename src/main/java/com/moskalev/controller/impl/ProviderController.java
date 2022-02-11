package com.moskalev.controller.impl;

import com.moskalev.controller.CrudController;
import com.moskalev.entities.Provider;
import com.moskalev.service.ProviderService;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/provider")
public class ProviderController  implements CrudController<Provider> {
    private ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }
    @RequestMapping(path = "/read/{id}")
    @Override
    public Provider read(@RequestParam String id) {
        return providerService.read(id);
    }
    @RequestMapping(path = "/readAll")
    @Override
    public List<Provider> readAll() {
        return providerService.readAll();
    }
    @RequestMapping(path = "/create/{provider}")
    @Override
    public void create(@RequestParam Provider provider) {
        providerService.create(provider);

    }
    @RequestMapping(path = "/delete/{provider}")
    @Override
    public void delete(Provider provider) {
        providerService.delete(provider);

    }

    @Override
    public void update(Provider provider, Provider newT) {

    }
}
