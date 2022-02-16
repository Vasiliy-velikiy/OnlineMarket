package com.moskalev.controller.impl;

import com.moskalev.entities.Product;
import com.moskalev.service.impl.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.1
 *  * @author Vasiliy  Moskalev
 *  @since 09.02.22
 * Class controller for handling requests to productrepository through the productservice */
@RestController
@RequestMapping(path = "/api/products")
public class ProductController  {
   private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**@param article -certain article that is unique
     * @return -certain product that we want to get */
    @RequestMapping(path = "/read/{article}")
    public Product read(@PathVariable String article) {
        return productService.read(article);
    }


    /**
     * @return list of Product*/
    @GetMapping(path = "/readAll")
    public List<Product> readAll() {
        return productService.readAll();
    }

    /**@param product -object that we want to create*/
    @PostMapping(path = "/create")
    public void create(@RequestBody Product product) {
        productService.create(product);

    }

    /**@param articleCode  -object that we want to delete*/
    @DeleteMapping(path = "/{articleCode}")
    public void delete(@PathVariable String articleCode) {
        productService.delete(articleCode);

    }

    /**@param articleCode  -certain name that is unique
     * @param newProduct-object that we want to update*/
    @PutMapping(path = "/{articleCode}")
    public void update(@PathVariable String articleCode,@RequestBody Product newProduct) {
        productService.update(articleCode,newProduct);

    }
}
