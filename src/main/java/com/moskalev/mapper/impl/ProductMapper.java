package com.moskalev.mapper.impl;

import com.moskalev.dto.productDto.ProductToCreateDto;
import com.moskalev.dto.productDto.ProductDto;
import com.moskalev.entities.Product;
import com.moskalev.mapper.Mapper;
import com.moskalev.repositories.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 24.02.22
 * Class mapper for conversion Product to ProductDto and ProductToCreateDto and back
 */
@Component
@RequiredArgsConstructor
public class ProductMapper implements Mapper<Product, ProductDto> {

    private final ProviderRepository providerRepository;

    /**
     * @param source -Person object
     * @return PersonDto object
     */
    public ProductDto toDto(Product source) {
        ProductDto productDto = new ProductDto();
        productDto.setProductName(source.getProductName());
        productDto.setDescription(source.getDescription());
        productDto.setArticleCode(source.getArticleCode());
        productDto.setPurchasePrice(source.getPurchasePrice());
        productDto.setProviderName(source.getProvider().getProviderName());
        return productDto;
    }

    /**
     * @param source -ProductDto object
     * @return Person object
     */
    @Override
    public Product fromDto(ProductDto source) {
        Product product = new Product();
        product.setProductName(source.getProductName());
        product.setDescription(source.getDescription());
        product.setArticleCode(source.getArticleCode());
        product.setPurchasePrice(source.getPurchasePrice());
        if (source.getProviderName() != null) {
            product.setProvider(providerRepository.findByProviderName(source.getProviderName()).get());
        }
        return product;
    }

    /**
     * @param source -ProductToCreateDto object
     * @return Person object
     */
    public Product fromCreateDto(ProductToCreateDto source) {
        Product product = new Product();
        product.setProductName(source.getProductName());
        product.setDescription(source.getDescription());
        product.setArticleCode(source.getArticleCode());
        product.setPurchasePrice(source.getPurchasePrice());
        product.setProvider(providerRepository.findByProviderName(source.getProviderName()).get());
        return product;
    }

    /**
     * @param objList -List of Product object
     * @return List of ProductDto object
     */
    @Override
    public List<ProductDto> convertListToDto(List<Product> objList) {
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : objList) {
            productDtoList.add(toDto(product));
        }
        return productDtoList;
    }
}
