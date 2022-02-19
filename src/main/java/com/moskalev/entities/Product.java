package com.moskalev.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**@version  1.1
 * @author Vasiliy  Moskalev
 * @since 03.02.22
 * This is class describes products that  customers wants to buy on OnlineMarket
 * */
//@Accessors(chain = true)
@Getter
@Setter
@Entity
@Table(name = "products" ,uniqueConstraints = {@UniqueConstraint(name = "unique_article",columnNames = "article_code")})
public class Product {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name="name")
    String productName;

    /**String field describes price which costumers can buy product*/
    @Column(name="price")
    Integer purchasePrice;

  /**String field describes provider who produce this product*/
    @Column(name = "provider_id")
    private Integer providerCode;

    /**String field describes main properties of product*/
    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    /**String field describes unique code  which distinguishes  one product from another */
    @Column(name = "article_code")
    private String articleCode;

    /**Each product will have number of basket, when custemers will put for purchase*/
    @ManyToOne()
    @JoinColumn(name = "basket_for_product_id")
    private BasketForProduct basketForProductNumber;



}
