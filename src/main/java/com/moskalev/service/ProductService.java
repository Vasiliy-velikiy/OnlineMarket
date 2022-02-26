package com.moskalev.service;


import com.moskalev.dto.productDto.ProductToCreateDto;
import com.moskalev.dto.productDto.ProductToUpdateDto;
import com.moskalev.entities.Product;
import com.moskalev.exeptions.ProductException;
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
    public Page<Product> readAll();

    /**
     * @param article - certain article that is unique
     * @return certain Product by article
     * @throws ProductException if  Product not found
     */
    Product read(String article);

    /**
     * @param newProduct -class that we want to create
     * @throws ProductException if Product with this article code already exists
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
    void update(Integer id, ProductToUpdateDto newProduct);


}
