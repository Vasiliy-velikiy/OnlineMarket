package com.moskalev.controller.impl;

import com.moskalev.controller.CrudController;
import com.moskalev.entities.Product;
import com.moskalev.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(path = "/api/product")
public class ProductController implements CrudController<Product> {
   private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/read/{id}")
    @Override
    public Product read(@RequestParam String id) {
        return productService.read(id);
    }

    @GetMapping(path = "/readAll")
    @Override
    public List<Product> readAll() {
        return productService.readAll();
    }

    @GetMapping(path = "/create/{product}")
    @Override
    public void create(@RequestParam Product product) {
        productService.create(product);

    }
    @GetMapping(path = "/delete/{product}")
    @Override
    public void delete(@RequestParam Product product) {
        productService.delete(product);

    }

    @Override
    public void update(Product product, Product newT) {

    }
}
