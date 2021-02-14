package com.enigma.Vcom.repositories;

import com.enigma.Vcom.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    Optional<User> findById(Long id);
}
