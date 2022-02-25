package com.moskalev.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


import static javax.persistence.FetchType.LAZY;

/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 03.02.22
 * This is class describes products that  customers wants to buy on OnlineMarket
 */
@Getter
@Setter
@Entity
@Table(name = "products", uniqueConstraints = {@UniqueConstraint(name = "unique_article", columnNames = "article_code")})
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name")
    String productName;

    /**
     * String field describes price which costumers can buy product
     */
    @Column(name = "price")
    Double purchasePrice;

    /**
     * String field describes provider who produce this product
     */
   // @ManyToOne(fetch = LAZY)
    @ManyToOne()
    @JoinColumn(name = "provider_id")
    private Provider provider;

    /**
     * String field describes main properties of product
     */
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    /**
     * String field describes unique code  which distinguishes  one product from another
     */
    @Column(name = "article_code")
    private String articleCode;

    /**
     * Each product will have number of basket, when customers will put for purchase
     */
    @ManyToOne()
    @JoinColumn(name = "basket_for_product_id")
    private BasketForProduct basketForProductNumber;
}
