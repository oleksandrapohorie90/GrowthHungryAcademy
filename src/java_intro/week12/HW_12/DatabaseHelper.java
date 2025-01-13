package java_intro.week12.HW_12;

import java.sql.*;

public class DatabaseHelper {
    private static final String DB_URL =
            "jdbc:sqlite:C:";

    static void initializeDatabase() {
        try (Connection conn =
                     DriverManager.getConnection(DB_URL); Statement stmt =
                     conn.createStatement()) {
            String userTable = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT UNIQUE);";
            String messageTable = "CREATE TABLE IF NOT EXISTS messages (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, message TEXT, timestamp DATETIME DEFAULT CURRENT_TIMESTAMP);";
            stmt.execute(userTable);
            stmt.execute(messageTable);
        } catch (SQLException e) {
            System.err.println("Error initializing database: " + e.getMessage());
        }
    }

    static void saveUser(String username) {
        String insertUserSQL = "INSERT OR IGNORE INTO users (username) VALUES (?);";
        try (Connection conn =
                     DriverManager.getConnection(DB_URL); PreparedStatement pstmt =
                     conn.prepareStatement(insertUserSQL)) {
            pstmt.setString(1, username);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error saving user: " + e.getMessage());
        }
    }

    static void saveMessage(String username, String message) {
        String insertMessageSQL = "INSERT INTO messages (username, message) VALUES (?, ?);";
        try (Connection conn =
                     DriverManager.getConnection(DB_URL); PreparedStatement pstmt =
                     conn.prepareStatement(insertMessageSQL)) {
            pstmt.setString(1, username);
            pstmt.setString(2, message);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error saving message: " + e.getMessage());
        }
    }
}
