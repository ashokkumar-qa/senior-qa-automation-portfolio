package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/insurance_db";
    private static final String USERNAME = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                URL,
                USERNAME,
                System.getenv("DB_PASSWORD")
        );
    }
}
