package com.moskalev.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

//@Accessors(chain = true)
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name="name")
    String productName;

    @Column(name="price")
    Integer purchasePrice;//закупочная цена

    @Column(name = "provider_id")
    private Integer providerCode;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", providerCode=" + providerCode +
                '}';
    }
}
