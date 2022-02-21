package com.moskalev.repositories;

import com.moskalev.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 01.02.22
 * Class repository for Person
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    /**
     * @param email that is unique
     * @return object of Optional for  null-safety
     */
    Optional<Person> findByEmail(String email);
}
