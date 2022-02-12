package com.moskalev.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
/*класс поставщика */
//@Accessors(chain = true)
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

    @Column(name = "legalAddress")
    private String legalAddress;

    @Column(name= "telefonNumber")
    private String telefonNumber;


    @Override
    public String toString() {
        return "Provider{" +
                "id=" + id +
                ", providerName='" + providerName + '\'' +
                '}';
    }
}
