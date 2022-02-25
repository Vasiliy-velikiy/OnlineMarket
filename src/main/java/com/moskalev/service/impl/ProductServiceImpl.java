package com.moskalev.service.impl;

import com.moskalev.dto.Impl.ProductToCreateDto;
import com.moskalev.dto.Impl.ProductToUpdateDto;
import com.moskalev.entities.Product;
import com.moskalev.exeptions.ProductException;
import com.moskalev.mapper.ProductMapper;
import com.moskalev.repositories.ProductRepository;
import com.moskalev.service.ProductService;
import org.hibernate.Hibernate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 05.02.22
 * Class service for product which provides interaction with product Repository
 */
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    /**
     * filed describes object for convert
     */
    private final ProductMapper objectMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper objectMapper) {
        this.productRepository = productRepository;
        this.objectMapper = objectMapper;
    }

    /**
     * @return list of all Product in table product
     */
    public Page<Product> readAll() {
        List<Product> listProducts = productRepository.findAll();
        for (Product productOptional : listProducts) {
            Hibernate.initialize(productOptional);
        }
        Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
        return new PageImpl<>(listProducts, firstPageWithTwoElements, listProducts.size());
    }

    /**
     * @param article - certain article that is unique
     * @return certain Product by article
     * @throws ProductException if  Product not found
     */
    public Product read(String article) {
        Optional<Product> productOptional = productRepository.findByArticleCode(article);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            Hibernate.initialize(product);
            return product;
        } else {
            throw new ProductException(String.format("Product with article: %s not found", article));
        }
    }

    /**
     * @param newProduct -class that we want to create
     * @throws ProductException if Product with this article code already exists
     */
    public void create(ProductToCreateDto newProduct) {
        Optional<Product> templateProduct = productRepository.findByArticleCode(newProduct.getArticleCode());
        if (!templateProduct.isPresent()) {
            Product product = objectMapper.fromDto(newProduct);
            productRepository.save(product);
        } else {
            throw new ProductException(String.format("Product with article code:  %s already exists", newProduct.getArticleCode()));
        }
    }

    /**
     * @param id -certain id code that is unique
     * @throws ProductException if  Product not found
     */
    public void delete(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            productRepository.delete(product);
        } else {
            throw new ProductException("Product not found");
        }
    }

    /**
     * @param id         -certain id Product
     * @param newProduct -new Product that we want to put in database
     * @throws ProductException if Product not found
     */
    public void update(Integer id, ProductToUpdateDto newProduct) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product target = productOptional.get();
            Product source = objectMapper.fromUpdateDto(newProduct);
            productRepository.save(objectMapper.merge(target, source));
        } else {
            throw new ProductException("Product not found");
        }
    }
}
