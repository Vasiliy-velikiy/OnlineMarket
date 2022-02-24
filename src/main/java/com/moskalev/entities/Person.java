package com.moskalev.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;


import static javax.persistence.EnumType.STRING;

/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 03.02.22
 * This is class describes customers who are a requester on OnlineMarket
 */
@Getter
@Setter
@Table(name = "persons", uniqueConstraints = {@UniqueConstraint(name = "unique_email", columnNames = "email")})
@Entity
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String firstName;
    @Column
    private String lastName;

    /**
     * String field describes contacting email address concrete person. This is unique fields because personal aria
     * in OnlineMarket has only one email
     */
    @Column(name = "email")
    private String email;

    /**
     * String field describes password of personal aria in OnlineMarket
     */
    @Column(name = "password")
    private String password;

    /**
     * String field describes role
     */
    @Column(name = "role")
    @Enumerated(STRING)
    private Role role;

    /**
     * Certain person has many baskets, certain basket has ONE person
     */
    @OneToMany(mappedBy = "owner")
    private List<BasketForProduct> basketForProductList;
}
