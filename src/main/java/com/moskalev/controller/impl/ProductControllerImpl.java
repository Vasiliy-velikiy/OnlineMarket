package com.moskalev.controller.impl;

import com.moskalev.dto.productDto.ProductToCreateDto;
import com.moskalev.dto.productDto.ProductDto;
import com.moskalev.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.1
 * * @author Vasiliy Moskalev
 * @since 09.02.22
 * Class controller for handling requests to productRepository through the productService
 */
@RestController
@RequestMapping(path = "/api/products")
@Tag(name = "Product", description = "this is product controller")
@ApiResponse(responseCode = "500", description = "Internal error")
@ApiResponse(responseCode = "400", description = "Validation failed")
@ApiResponse(responseCode = "404", description = "Product not found")
public class ProductControllerImpl {

    private final ProductService productServiceImpl;

    public ProductControllerImpl(ProductService productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    /**
     * @param article -certain article that is unique
     * @return -certain product that we want to get
     */
    @Operation(description = "Find user by email")
    @ApiResponse(responseCode = "200", description = "Product successfully found")
    @ApiResponse(responseCode = "500", description = "Product not found")
    @GetMapping(path = "/article")
    public ProductDto read(@RequestParam String article) {
        return productServiceImpl.read(article);
    }

    /**
     * @return list of Product
     */
    @Operation(description = "Find all products")
    @ApiResponse(responseCode = "200", description = "All products successfully found")
    @ApiResponse(responseCode = "500", description = "Products not found")
    @GetMapping
    // @PreAuthorize("hasRole('EMPLOYEE') || hasAuthority('ROLE_EMPLOYEE')" )
    public Page<ProductDto> readAll() {
        return productServiceImpl.readAll();
    }

    /**
     * @param newProduct -object that we want to create
     */
    @Operation(description = "Create product")
    @ApiResponse(responseCode = "200", description = "Product successfully created")
    @ApiResponse(responseCode = "500", description = "Product  already exists")
    @PostMapping
    //@PreAuthorize("hasRole('EMPLOYEE') || hasAuthority('ROLE_EMPLOYEE')" )
    public void create(@RequestBody ProductToCreateDto newProduct) {
        productServiceImpl.create(newProduct);
    }

    /**
     * @param id -object that we want to delete
     */
    @Operation(description = "Delete product by id")
    @ApiResponse(responseCode = "204", description = "Product successfully deleted")
    @ApiResponse(responseCode = "500", description = "Product not found")
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id) {
        productServiceImpl.delete(id);
    }

    /**
     * @param id                -certain  id that is unique
     * @param newProduct-object that we want to update
     */
    @Operation(description = "Update product")
    @ApiResponse(responseCode = "200", description = "Product successfully updated")
    @ApiResponse(responseCode = "500", description = "Product not found")
    @PatchMapping(path = "/{id}")
    public void update(@PathVariable Integer id, @RequestBody ProductDto newProduct) {
        productServiceImpl.update(id, newProduct);
    }
}