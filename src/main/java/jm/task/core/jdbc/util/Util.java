package jm.task.core.jdbc.util;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    Connection connection;

    Driver driver;

    public void OpenConnection(String url, String username, String pass) throws SQLException {
        try {
            driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException ex) {
            System.out.println("Error create driver");
            return;
        }

        try {
            connection = DriverManager.getConnection(url, username, pass);
            if (!connection.isClosed()) {
                System.out.println("Connection - good!");
            }
        } catch (SQLException ex) {
            System.out.println("Error connection");
        }
    }

    public void CloseConnection() {
        try {
            if (!connection.isClosed()) {
                connection.close();
                System.out.println("Connection - closed!");
            }
        } catch (SQLException sqlException) {
            System.out.println("Cannot close connection");
        }
    }

}