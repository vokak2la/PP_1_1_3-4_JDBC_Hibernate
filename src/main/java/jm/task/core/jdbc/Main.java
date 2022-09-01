package jm.task.core.jdbc;

import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
      Util util = new Util();
      util.OpenConnection ("jdbc:mysql://127.0.0.1:3306/my_db","bestuser" , "bestuser" );
      util.CloseConnection();

    }
}
