package com.moskalev.entities;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
//@Accessors(chain = true)
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

    @Column(name="email")
    private String email;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
