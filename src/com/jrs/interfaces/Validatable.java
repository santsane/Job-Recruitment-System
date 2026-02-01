package com.jrs.interfaces;

public interface Validatable {
    boolean isValid(); // Abstract method

    default void logStatus() { // Default method
        System.out.println("[LOG] Validation check performed on: " + this.getClass().getSimpleName());
    }

    static boolean isEmailValid(String email) { // Static method
        return email != null && email.contains("@");
    }
}