package com.nirvana.app.repositories;

// import statements
import com.nirvana.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // method to find user by username
    Optional<User> findByUsername(String username);
}
