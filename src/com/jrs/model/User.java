package com.jrs.model;

public abstract class User {
    protected int id;
    protected String name;
    protected String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Abstract method
    public abstract String getRole();

    // Concrete method
    public void displayInfo() {
        System.out.println("ID: " + id + " | " + name + " (" + email + ")");
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}