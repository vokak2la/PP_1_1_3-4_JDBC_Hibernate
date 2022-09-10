package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {


//    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
private static Connection connection = null;

    public static Connection OpenConnection() {

//
//        try {            Class.forName(DRIVER);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
// проверяем работает ли без объявленного драйвера - работает!
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
// закрывать принудительно не нужно если будет закрываться  в ресурсах

//    public void CloseConnection() {
//        Connection connection = null;
//        try {
//            if (!connection.isClosed()) {
//                connection.close();
//                System.out.println("Connection - closed!");
//            }
//        } catch (SQLException sqlException) {
//            System.out.println("Cannot close connection");
//        }
//    }

}