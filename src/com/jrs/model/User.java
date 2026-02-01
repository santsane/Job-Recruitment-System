package com.jrs.model;

import com.jrs.interfaces.Validatable;

public abstract class User implements Validatable {
    protected int id;
    protected String name;
    protected String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Abstract methods, polymorphism
    public abstract String getRole();
    public abstract String getPermissions(); // ADDED THIS

    // Concrete method
    public void displayInfo() {
        System.out.println("ID: " + id + " | Name: " + name + " | Role: " + getRole());
    }

    // validatable interface
    @Override
    public boolean isValid() {
        // Static method from validatable interface
        return name != null && !name.isEmpty() && Validatable.isEmailValid(email);
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}