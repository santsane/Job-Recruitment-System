package com.jrs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // database settings
    private static final String URL = "jdbc:postgresql://localhost:5432/job_rec_system";
    private static final String USER = "postgres";
    private static final String PASS = "123654As";

    public static Connection getConnection() throws SQLException {
        try {
            // Load postgres driver
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            // check if it works
            if (conn != null) {
                return conn;
            } else {
                throw new SQLException("Failed to make connection");
            }
        } catch (ClassNotFoundException e) {
            // if the JAR file is missing
            throw new SQLException("PostgreSQL JDBC Driver not found.", e);
        }
    }
}