package com.jrs.controller;

import com.jrs.exception.InvalidInputException;
import com.jrs.model.Candidate;
import com.jrs.model.Recruiter;
import com.jrs.model.User;
import com.jrs.service.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        System.out.println("Job Recruitment System.");

        try {
            // Register a recruiter
            System.out.println("\nRegistering a new Recruiter.");
            Recruiter recruiter = new Recruiter(0, "Apple", "hr@apple.com", "Apple Company");
            userService.registerUser(recruiter);
            System.out.println("Recruiter has been added.");

            // Register a candidate
            System.out.println("\nRegistering a new Candidate.");
            Candidate candidate = new Candidate(0, "Sanzhar Zhunis", "sanzhar.zhunis@email.com", "http://linkedin.com/johndoe");
            userService.registerUser(candidate);
            System.out.println("Candidate has been added.");

            // Try registering duplicate email - should fail
            System.out.println("\nRegistering duplicate email.");
            Candidate duplicate = new Candidate(0, "Clone User", "sanzhar.zhunis@email.com", "no-link");
            userService.registerUser(duplicate);

        } catch (InvalidInputException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }

        // Display all registered users
        try {
            System.out.println("\n Registered Users:");
            List<User> users = userService.listAllUsers();

            for (User u : users) {
                u.displayInfo();
                System.out.println("Role: " + u.getRole());
            }
        } catch (Exception e) {
            System.err.println("Error retrieving users: " + e.getMessage());
        }
    }
}