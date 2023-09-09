package com.adiltestelin.sphere.repository;

import com.adiltestelin.sphere.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByMail(String mail);

    boolean existsByUsername(String username);
}
