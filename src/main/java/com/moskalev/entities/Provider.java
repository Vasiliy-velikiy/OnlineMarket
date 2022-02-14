package com.moskalev.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**@version  1.1
 * @author Vasiliy  Moskalev
 * @since 03.02.22
 * This is class describes providers who produces concrete product
 * */

@Entity
@Getter
@Setter
@Table(name = "provider" ,uniqueConstraints = {@UniqueConstraint(name = "unique_providerName",columnNames = "providerName")})
public class Provider {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "providerName")
    private String providerName;

    /**String field describes contacting address where locating  concrete provider*/
    @Column(name = "legalAddress")
    private String legalAddress;

     /**String field describes contacting telefon numbers of concrete provider*/
    @Column(name= "telefonNumber")
    private String telefonNumber;


}
