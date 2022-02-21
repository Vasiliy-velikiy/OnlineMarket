package com.moskalev.entities;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;


/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 03.02.22
 * This is class describes providers who providers concrete product
 */
@Entity
@Getter
@Setter
@Table(name = "providers", uniqueConstraints = {@UniqueConstraint(name = "unique_provider_name", columnNames = "provider_name")})
public class Provider {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "provider_name")
    private String providerName;

    /**
     * String field describes contacting address where locating  concrete provider
     */
    @Column(name = "legal_address")
    private String legalAddress;

    /**
     * String field describes contacting telefon numbers of concrete provider
     */
    @Column(name = "telefon_number")
    private String telefonNumber;
}
