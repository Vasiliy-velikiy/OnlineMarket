package com.moskalev.controller.impl;

import com.moskalev.controller.ProviderController;
import com.moskalev.dto.Impl.ProviderToCreateDto;
import com.moskalev.dto.Impl.ProviderToUpdateDto;
import com.moskalev.entities.Provider;
import com.moskalev.service.ProviderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.1
 * * @author Vasiliy  Moskalev
 * @since 09.02.22
 * Class controller for handling requests to provider repository through the provider service
 */
@RestController
@RequestMapping(path = "/api/providers")
@Tag(name = "Provider", description = "this is provider controller")
@ApiResponse(responseCode = "500", description = "Internal error")
@ApiResponse(responseCode = "400", description = "Validation failed")
@ApiResponse(responseCode = "404", description = "Provider not found")
public class ProviderControllerImpl implements ProviderController {
    private final ProviderService providerServiceImpl;

    public ProviderControllerImpl(ProviderService providerServiceImpl) {
        this.providerServiceImpl = providerServiceImpl;
    }

    /**
     * @param providerName -certain name that is unique
     * @return -certain provider that we want to get
     */
    @Operation(description = "Find provider by providerName")
    @ApiResponse(responseCode = "200", description = "Provider successfully found")
    @ApiResponse(responseCode = "500", description = "Provider not found")
    @GetMapping(path = "/providerName")
    public Provider read(@RequestParam String providerName) {
        return providerServiceImpl.read(providerName);
    }

    /**
     * @return list of Providers
     */
    @Operation(description = "Find all providers")
    @ApiResponse(responseCode = "200", description = "All providers successfully found")
    @ApiResponse(responseCode = "500", description = "Providers not found")
    @GetMapping
    public Page<Provider> readAll() {
        return providerServiceImpl.readAll();
    }

    /**
     * @param newProvider-object that we want to create
     */
    @ApiResponse(responseCode = "200", description = "Provider successfully created")
    @ApiResponse(responseCode = "500", description = "Provider already exists")
    @PostMapping
    public void create(@RequestBody ProviderToCreateDto newProvider) {
        providerServiceImpl.create(newProvider);
    }

    /**
     * @param id -object that we want to delete
     */
    @Operation(description = "Delete provider by id")
    @ApiResponse(responseCode = "204", description = "Provider successfully deleted")
    @ApiResponse(responseCode = "500", description = "Provider not found")
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id) {
        providerServiceImpl.delete(id);
    }

    /**
     * @param id      -certain name that is unique
     * @param newProvider-object that we want to update
     */
    @Operation(description = "Update provider")
    @ApiResponse(responseCode = "200", description = "Provider successfully updated")
    @ApiResponse(responseCode = "500", description = "Provider not found")
    @PatchMapping(path = "/{id}")
    public void update(@PathVariable Integer id, @RequestBody ProviderToUpdateDto newProvider) {
        providerServiceImpl.update(id, newProvider);
    }
}
