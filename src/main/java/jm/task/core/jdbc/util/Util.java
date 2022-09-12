package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {


    private static Connection connection = null;

    public static Connection OpenConnection() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doit", "bestuser", "bestuser");
            if (!connection.isClosed()) {
                System.out.println("Connection - good!");
            }
        } catch (SQLException ex) {
            System.out.println("Error connection");
        }
        return connection;
    }
}
