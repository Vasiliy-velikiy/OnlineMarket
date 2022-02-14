package com.moskalev.repositories;

import com.moskalev.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
/**@version  1.1
 * @author Vasiliy Moskalev
 * Class repository for Role*/
public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role>findByName(String name);
}
