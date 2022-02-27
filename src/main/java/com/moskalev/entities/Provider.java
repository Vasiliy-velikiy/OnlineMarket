package com.moskalev.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;
import static javax.persistence.CascadeType.*;

/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 03.02.22
 * This is class describes providers who providers concrete product
 */
@Entity
@Getter
@Setter
@Table(name = "providers")
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
     * String field describes contacting telephone numbers of concrete provider
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * String field describes that each provider has list of products
     */

    @OneToMany(mappedBy = "provider",
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = {PERSIST, MERGE, DETACH, REFRESH})
    private List<Product> productsOfProvider;
}
