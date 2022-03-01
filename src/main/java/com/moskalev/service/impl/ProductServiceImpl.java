package com.moskalev.service.impl;


import com.moskalev.dto.productDto.ProductToCreateDto;
import com.moskalev.dto.productDto.ProductDto;
import com.moskalev.entities.Product;
import com.moskalev.entities.Provider;
import com.moskalev.exeptions.ProductException;
import com.moskalev.mapper.MergeProductMapper;
import com.moskalev.mapper.impl.ProductMapper;
import com.moskalev.repositories.ProductRepository;
import com.moskalev.repositories.ProviderRepository;
import com.moskalev.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 05.02.22
 * Class service for product which provides interaction with product Repository
 */
@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProviderRepository providerRepository;
    /**
     * filed describes object for convert
     */
    private final MergeProductMapper mergeProductMapper;

    private final ProductMapper productMapper;

    /**
     * @return list of all Product in table product
     */
    @Override
    public Page<ProductDto> readAll() {
        List<ProductDto> listProductsDto = productMapper.convertListToDto(productRepository.findAll());
        Pageable firstPageWithTwoElements = PageRequest.of(0, listProductsDto.size());
        return new PageImpl<>(listProductsDto, firstPageWithTwoElements, listProductsDto.size());
    }

    /**
     * @param article - certain article that is unique
     * @return certain Product by article
     * @throws ProductException if  Product not found
     */
    @Override
    public ProductDto read(String article) {
        Optional<Product> productOptional = productRepository.findByArticleCode(article);
        if (productOptional.isPresent()) {
            return productMapper.toDto(productOptional.get());
        } else {
            throw new ProductException(String.format("Product with article: %s not found", article));
        }
    }

    /**
     * @param newProduct -class that we want to create
     * @throws ProductException if Product with this article code already exists
     * @throws ProductException if Provider is not found
     */
    @Override
    public void create(ProductToCreateDto newProduct) {
        Optional<Product> templateProduct = productRepository.findByArticleCode(newProduct.getArticleCode());
        if (!templateProduct.isPresent()) {
            Optional<Provider> productProvider = providerRepository.findByProviderName(newProduct.getProviderName());
            if (productProvider.isPresent()) {
                Product product = productMapper.fromCreateDto(newProduct);
                productRepository.save(product);
            } else {
                throw new ProductException(String.format("Provider %s  is not found", newProduct.getProviderName()));
            }
        } else {
            throw new ProductException(String.format("Product with article code:  %s already exists", newProduct.getArticleCode()));
        }
    }

    /**
     * @param id -certain id code that is unique
     * @throws ProductException if  Product not found
     */
    @Override
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
    @Override
    public void update(Integer id, ProductDto newProduct) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product target = productOptional.get();
            Product source = productMapper.fromDto(newProduct);
            productRepository.save(mergeProductMapper.merge(target, source));
        } else {
            throw new ProductException("Product not found");
        }
    }
}
