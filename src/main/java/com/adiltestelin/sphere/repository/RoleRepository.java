package com.adiltestelin.sphere.repository;

import com.adiltestelin.sphere.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
