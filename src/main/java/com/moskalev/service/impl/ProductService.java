package com.moskalev.service.impl;

import com.moskalev.entities.Product;
import com.moskalev.exeptions.ResourseNotFoundExeption;
import com.moskalev.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
/**@version  1.1
 *  @author Vasiliy Moskalev
 * @since 05.02.22
 * Class service for product which provides interaction with prodcutRepository  */
@Service
public class ProductService  {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    /**@return list of all Product in table product*/
    public List<Product> readAll() {
        return productRepository.findAll();
    }

    /**@param article - certain article that is unique
     * @return certain Product by article
     * @throws ResourseNotFoundExeption if  Product not found*/
    public Product read(String article) {
        Optional<Product> productOption= productRepository.findByArticleCode(article);
        if(productOption.isPresent()){
            return productOption.get();
        }
        else throw new ResourseNotFoundExeption(String.format("Product with article: %s not found",article));
    }

    /**@param product -class that we want to create**/
    public void create(Product product) {
        productRepository.save(product);
    }


    /**@param article -certain article that is unique
     *  @throws ResourseNotFoundExeption if  Product not found*/
    public void delete( String article) {
        Optional<Product> productOptional=productRepository.findByArticleCode(article);
        if(productOptional.isPresent()){
            Product product=productOptional.get();
            productRepository.delete(product);

        }else { throw new ResourseNotFoundExeption("Product not found");
        }
    }

    /**@param articleCode -certain email
     * @param newProduct -new Prodcut that we want to put in database
     * @throws ResourseNotFoundExeption if Product not found*/
    public void update(String articleCode, Product newProduct) {
        Optional<Product>productOptional=productRepository.findByArticleCode(articleCode);

        if(productOptional.isPresent()){
            Product product=productOptional.get();
            product.setPurchasePrice(newProduct.getPurchasePrice());
            product.setDescription(product.getDescription());
            product.setProductName(newProduct.getProductName());
            product.setProviderCode(newProduct.getProviderCode());
            product.setArticleCode(newProduct.getArticleCode());
            productRepository.saveAndFlush(product);
        }
        else throw new ResourseNotFoundExeption("Product not found");

    }
}
