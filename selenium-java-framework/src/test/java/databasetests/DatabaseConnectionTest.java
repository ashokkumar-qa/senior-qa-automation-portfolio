package databasetests;

import database.DatabaseUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnectionTest {

    private static final Logger logger =
            LogManager.getLogger(DatabaseConnectionTest.class);

    @Test
    public void verifyDatabaseConnection() throws Exception {

        Connection connection = DatabaseUtil.getConnection();

        Assert.assertNotNull(
                connection,
                "Database connection was not established"
        );

        logger.info("Database connection established successfully");

        connection.close();
    }

    @Test
    public void verifyCustomerExists() throws SQLException {

        String query =
                "SELECT first_name FROM customers WHERE customer_id = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(query)) {

            preparedStatement.setInt(1, 1);

            try (ResultSet resultSet =
                         preparedStatement.executeQuery()) {

                Assert.assertTrue(
                        resultSet.next(),
                        "Customer was not found in database"
                );

                String actualFirstName =
                        resultSet.getString("first_name");

                Assert.assertEquals(
                        actualFirstName,
                        "Vinoth",
                        "Customer first name did not match"
                );
            }
        }
    }
}