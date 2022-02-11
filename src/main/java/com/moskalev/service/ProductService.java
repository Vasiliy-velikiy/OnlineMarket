package com.moskalev.service;

import com.moskalev.entities.Person;
import com.moskalev.entities.Product;
import com.moskalev.exeptions.ResourseNotFoundExeption;
import com.moskalev.repositories.ProductRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService  {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    public List<Product> readAll() {
        return productRepository.findAll();
    }


    public Product read(String t) {
        Optional<Product> productOption= productRepository.findById(Integer.valueOf(t));
        if(productOption.isPresent()){
            return productOption.get();
        }
        else throw new ResourseNotFoundExeption(String.format("Product with id %s not found",t));
    }


    public void create(Product product) {
        productRepository.save(product);
    }


    public void delete( Integer id) {
        productRepository.deleteById(id);
    }


    public void update(Product product, Product newT) {

    }
}
