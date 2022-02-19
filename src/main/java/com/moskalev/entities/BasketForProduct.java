package com.moskalev.entities;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;

/**@version  1.1
 * @author Vasiliy  Moskalev
 * @since 03.02.22
 * This is class describes basket For Product  */
@Getter
@Setter
@Table(name = "baskets",uniqueConstraints = {@UniqueConstraint(name = "unique_id",columnNames = "id")})
@Entity
public class BasketForProduct {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**each basket belongs certain person */
   @ManyToOne()
   @JoinColumn(name = "owner_id")
    private Person owner;



    /**basket has certain list of product, which the user wants to buy*/
    @OneToMany(mappedBy = "basketForProductNumber")
    private List<Product> productList;

}
