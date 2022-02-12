package com.moskalev.controller.impl;

import com.moskalev.entities.Product;
import com.moskalev.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/api/product")
public class ProductController  {
   private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/read/{id}")
    public Product read(@RequestParam String id) {
        return productService.read(id);
    }

    @GetMapping(path = "/readAll")
    public List<Product> readAll() {
        return productService.readAll();
    }

    @PostMapping(path = "/create")
    public void create(@RequestBody Product product) {
        productService.create(product);

    }
    @DeleteMapping(path = "/{articleCode}")
    public void delete(@PathVariable String articleCode) {
        productService.delete(articleCode);

    }
    @PutMapping(path = "/{articleCode}")
    public void update(@PathVariable String articleCode,@RequestBody Product newProduct) {
        productService.update(articleCode,newProduct);

    }
}
