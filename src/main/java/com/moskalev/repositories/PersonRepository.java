package com.moskalev.repositories;

import com.moskalev.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**@version  1.1
 * @author Vasiliy Moskalev
 * @since 01.02.22
 * Class repository for Person*/

//репозиторий является интерфейсом, который наследуется от другого интерфейса JpaRepository<>
//для него необходимо указать с какой сущность он должен работать, у нас это person
//и тип данных у поля id данной сущности, у нас это Integer
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
  /**@param email that is unique
   * @return object of Optional for  null-safety
   *        */
  Optional <Person> findByEmail(String email);

  /**@param email that is unique*/
  void deleteByEmail(String email);
}
