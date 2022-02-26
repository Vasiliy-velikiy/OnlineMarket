package com.moskalev.entities;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 03.02.22
 * This is class describes order For Product
 */
@Getter
@Setter
@Table(name = "orders")
@Entity
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * each basket belongs certain person
     */
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,
                    CascadeType.REFRESH})
    @JoinColumn(name = "owner_id",referencedColumnName = "id", foreignKey = @ForeignKey(name = "products_provider_id_fk"))
    private Person owner;

    /**
     * basket has certain list of product, which the user wants to buy
     */
    @ManyToMany
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
   private List<Product> products;


    public void addProducts(Product product) {
            products.add(product);

    }

    public void removeProducts(Product product) {
        products.remove(product);

    }
}
