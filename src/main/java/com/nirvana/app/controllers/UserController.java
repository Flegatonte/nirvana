package com.nirvana.app.controllers;

import com.nirvana.app.models.User;
import com.nirvana.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired; // import for Autowired
import org.springframework.http.HttpStatus; // import for HttpStatus
import org.springframework.http.ResponseEntity; // import for ResponseEntity
import org.springframework.web.bind.annotation.*; // import for RestController, PostMapping, etc.

@RestController // indicates that this class is a REST controller
@RequestMapping("/api/users") // base URL for user-related endpoints
public class UserController {

    private final UserService userService; // service for user operations

    @Autowired // allows Spring to inject dependencies
    public UserController(UserService userService) {
        this.userService = userService; // initialize userService
    }

    // endpoint to register a new user
    @PostMapping("/register") // maps POST requests to /api/users/register
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User newUser = userService.registerUser(user); // register the new user
        return new ResponseEntity<>(newUser, HttpStatus.CREATED); // return created user with status 201
    }

    // other user-related endpoints can go here (e.g., login, get user, etc.)
}