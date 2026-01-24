package com.jrs.repository;

import com.jrs.model.*;
import com.jrs.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Create(entity)
    public void create(User user) throws SQLException {
        String sql = "INSERT INTO users (name, email, role, additional_info) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Requirement: PreparedStatement

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getRole());

            // Handle subclass data
            if (user instanceof Recruiter) {
                pstmt.setString(4, ((Recruiter) user).getCompanyName());
            } else if (user instanceof Candidate) {
                pstmt.setString(4, ((Candidate) user).getResumeLink());
            }

            pstmt.executeUpdate();
        }
    }

    // getAll()
    public List<User> getAll() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) { // Requirement: ResultSet

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String role = rs.getString("role");
                String info = rs.getString("additional_info");

                if ("RECRUITER".equals(role)) {
                    users.add(new Recruiter(id, name, email, info));
                } else {
                    users.add(new Candidate(id, name, email, info));
                }
            }
        }
        return users;
    }

    // delete(id)
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}