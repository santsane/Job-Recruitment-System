package com.jrs.service;

import com.jrs.exception.DuplicateResourceException;
import com.jrs.exception.InvalidInputException;
import com.jrs.model.User;
import com.jrs.repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    // Composition
    private final UserRepository userRepository = new UserRepository();

    public void registerUser(User user) throws InvalidInputException, SQLException {
        // Validation
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new InvalidInputException("Validation Failed: Empty name");
        }

        if (user.getEmail() == null || !user.getEmail().contains("@")) {
            throw new InvalidInputException("Validation Failed: Invalid email");
        }

        // Business
        // Unique email check
        List<User> existingUsers = userRepository.getAll();
        for (User u : existingUsers) {
            if (u.getEmail().equalsIgnoreCase(user.getEmail())) {
                throw new DuplicateResourceException("Business rule broken: Email " + user.getEmail() + " taken");
            }
        }

        userRepository.create(user);
    }

    public List<User> listAllUsers() throws SQLException {
        return userRepository.getAll();
    }

    public void removeUser(int id) throws SQLException {
        userRepository.delete(id);
    }
}