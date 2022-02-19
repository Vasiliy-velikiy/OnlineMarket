package com.moskalev.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@Getter
@Setter(value = AccessLevel.PRIVATE)
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue
    Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)){
            return false;
        }//потому что вместо ожидаемого обьекта может придти прокси и сравнить его с прокси
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
