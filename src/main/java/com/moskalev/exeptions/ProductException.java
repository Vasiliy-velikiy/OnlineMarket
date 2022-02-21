package com.moskalev.exeptions;
/**@version  1.1
 * @author Vasiliy  Moskalev
 * @since 21.02.22
 * Class runtime exception if  Product not found or already exists */
public class ProductException extends  RuntimeException {
    public ProductException(String message) {
        super(message);
    }

}