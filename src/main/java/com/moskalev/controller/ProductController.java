package com.moskalev.controller;


import com.moskalev.dto.productDto.ProductToCreateDto;
import com.moskalev.dto.productDto.ProductDto;
import org.springframework.data.domain.Page;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 25.02.22
 * interface controller for product controller
 */
public interface ProductController {

    /**
     * @param article -certain article that is unique
     * @return -certain product that we want to get
     */
    ProductDto read(String article);

    /**
     * @return list of Product
     */
    Page<ProductDto> readAll();

    /**
     * @param newProduct -object that we want to create
     */
    void create(ProductToCreateDto newProduct);

    /**
     * @param id -object that we want to delete
     */
    void delete(Integer id);

    /**
     * @param id                -certain  id that is unique
     * @param newProduct-object that we want to update
     */
    void update(Integer id, ProductDto newProduct);
}
