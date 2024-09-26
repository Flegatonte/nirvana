package com.nirvana.app.services;


import com.nirvana.app.models.User;
import com.nirvana.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired; // import for Autowired
import org.springframework.stereotype.Service; // import for Service
import org.springframework.security.crypto.password.PasswordEncoder; // import for PasswordEncoder

import java.util.Optional; // import for Optional

@Service // indicates that this class is a service component
public class UserService {

    private final UserRepository userRepository; // repository for user operations
    private final PasswordEncoder passwordEncoder; // encoder for passwords

    @Autowired // allows Spring to inject dependencies
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository; // initialize userRepository
        this.passwordEncoder = passwordEncoder; // initialize passwordEncoder
    }

    // method to register a new user
    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // encode the user's password
        return userRepository.save(user); // save the user to the database
    }

    // method to find a user by username
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username); // return user if found
    }

    // other user-related methods can go here (e.g., update, delete, etc.)
}
