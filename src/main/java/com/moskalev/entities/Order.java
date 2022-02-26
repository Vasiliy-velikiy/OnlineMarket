package com.moskalev.entities;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;

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
    @ManyToOne()
    @JoinColumn(name = "owner_id")
    private Person owner;

    /**
     * basket has certain list of product, which the user wants to buy
     */
    @OneToMany(mappedBy = "order")
    private List<Product> products;
}
