package com.adiltestelin.sphere.repository;

import com.adiltestelin.sphere.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByMail(final String mail);

    Boolean existsByUsername(final String username);

    Optional<User> findByUsername(final String username);

    Optional<User> findByMail(final String mail);
}
