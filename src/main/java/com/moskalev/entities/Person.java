package com.moskalev.entities;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**@version  1.1
 * @author Vasiliy Moskalev
 * This is class describes customers who  reqister on OnlineMarket*/
@Getter
@Setter
@Table(name = "person" ,uniqueConstraints = {@UniqueConstraint(name = "unique_email",columnNames = "email")})
@Entity
public class Person {


    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String firstName;
    @Column
    private String lastName;

    /**String field describes contacting email address concrete person. This is unique fields because personal aria
     * in OnlineMarket has only one email*/
    @Column(name="email")
    private String email;

    /**String field describes password of personal aria in OnlineMarket*/
    @Column(name = "password")
   private String password;

    @ManyToMany()
    @JoinTable(name = "person_role",
               joinColumns = @JoinColumn(name = "person_id",referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    private List<Role> roleList;


    /**Certain person has many baskets, certain basket has ONE person*/
    @OneToMany(mappedBy = "owner")
    private List<BasketForProduct> basketForProductList;






}
