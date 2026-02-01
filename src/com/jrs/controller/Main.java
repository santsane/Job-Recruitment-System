package com.jrs.controller;

import com.jrs.model.*;
import com.jrs.repository.UserRepository;
import com.jrs.service.UserService;
import com.jrs.util.ReflectionUtils;
import com.jrs.util.SortingUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Repo setup
            UserRepository repo = new UserRepository();

            // Passing it into the service-Dependency Injection
            UserService userService = new UserService(repo);

            // Deleting old data for UNIQUE email check
            System.out.println("Cleaning database.");
            List<User> currentData = repo.getAll();
            for (User u : currentData) {
                repo.delete(u.getId());
            }

            System.out.println("[Step 1] Make the user objects");
            User u1 = new Recruiter(0, "Krabs HR", "krabs@company.com", "KrustyKrabs");
            User u2 = new Candidate(0, "Squidward Dev", "squidward@gmail.com", "https://resume.com/squidward");
            User u3 = new Candidate(0, "Spongebob Dev", "spongebob@gmail.com", "https://resume.com/spongebob");

            // Register all users using the service layer
            userService.registerUser(u1);
            userService.registerUser(u2);
            userService.registerUser(u3);
            System.out.println("System: All users saved in database.");

            // Reflection
            System.out.println("\n[Step 2] Look at class info at runtime");
            ReflectionUtils.inspectClass(u1);

            // Get users and sort them with lambdas
            System.out.println("\n[Step 3] Sorting the list with functions");
            List<User> users = userService.getAllUsers();

            System.out.println("Current order:");
            users.forEach(u -> System.out.println(" > " + u.getName()));

            // Call our lambda sorting utility
            SortingUtils.sortUsersByName(users);

            System.out.println("After sorting by name (Lambda):");
            users.forEach(u -> System.out.println(" > " + u.getName()));

            // Use the default method from our interface
            System.out.println("\n[Step 4] Check interface default method");
            u1.logStatus();

        } catch (Exception e) {
            System.err.println("Error happened: " + e.getMessage());
            e.printStackTrace();
        }
    }
}