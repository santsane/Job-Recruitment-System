package com.jrs.service;

import com.jrs.exception.DuplicateResourceException;
import com.jrs.exception.InvalidInputException;
import com.jrs.model.User;
import com.jrs.repository.interfaces.CrudRepository;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    // Dependency Inversion- Depends on (CrudRepository) not Concretion
    private final CrudRepository<User> userRepository;

    // Constructor Injection
    public UserService(CrudRepository<User> userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(User user) throws InvalidInputException, SQLException, DuplicateResourceException {
        // Validation Logic
        if (!user.isValid()) {
            throw new InvalidInputException("Invalid User Data: Name or Email is incorrect.");
        }

        // Business Logic- check duplicates
        List<User> existingUsers = userRepository.getAll();
        for (User u : existingUsers) {
            if (u.getEmail().equalsIgnoreCase(user.getEmail())) {
                throw new DuplicateResourceException("User with email " + user.getEmail() + " already exists.");
            }
        }

        // Persistence
        userRepository.create(user);
    }

    public List<User> getAllUsers() throws SQLException {
        return userRepository.getAll();
    }
}