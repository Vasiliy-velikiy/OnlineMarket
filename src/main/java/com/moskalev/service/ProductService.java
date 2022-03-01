package com.moskalev.service;


import com.moskalev.dto.productDto.ProductToCreateDto;
import com.moskalev.dto.productDto.ProductDto;
import org.springframework.data.domain.Page;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 04.02.22
 * Class interface for PersonServiceImpl
 */
public interface ProductService {

    /**
     * @return list of all Product in table product
     */
    Page<ProductDto> readAll();

    /**
     * @param article - certain article that is unique
     * @return certain Product by article
     */
    ProductDto read(String article);

    /**
     * @param newProduct -class that we want to create
     */
    void create(ProductToCreateDto newProduct);

    /**
     * @param id -certain id code that is unique
     */
    void delete(Integer id);

    /**
     * @param id         -certain id Product
     * @param newProduct -new Product that we want to put in database
     */
    void update(Integer id, ProductDto newProduct);

}
