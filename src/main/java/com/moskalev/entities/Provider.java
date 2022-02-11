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
@Table(name = "provider")
public class Provider {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String providerName;

    @Override
    public String toString() {
        return "Provider{" +
                "id=" + id +
                ", providerName='" + providerName + '\'' +
                '}';
    }
}
