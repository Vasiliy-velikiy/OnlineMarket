package com.moskalev.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
/**@version  1.1
 * @author Vasiliy  Moskalev
 * @since 13.02.22
 * This is class describes roles of person( Admin, client and other)
 * */
@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "roleList")
    private List<Person> persons;


   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;
        if (name != null ? !name.equals(role.name) : role.name != null) return false;
        return persons != null ? persons.equals(role.persons) : role.persons == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (persons != null ? persons.hashCode() : 0);
        return result;
    }*/
}
