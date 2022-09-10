package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;


import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //  Util.OpenConnection();

        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();

        //  userDaoJDBC.dropUsersTable(); test

        userDaoJDBC.createUsersTable();
        //-------------------------------------------
        userDaoJDBC.cleanUsersTable();
        //-------------------------------------------
        userDaoJDBC.saveUser("Sasha", "Ivanov", (byte) 11);
        userDaoJDBC.saveUser("Masha", "Petrova", (byte) 22);
        userDaoJDBC.saveUser("Pasha", "Sidorov", (byte) 33);
        userDaoJDBC.saveUser("Ivanushka", "Durachok", (byte) 44);
        //-----------------------------------------------
        userDaoJDBC.removeUserById(2);
        //-------------------------------------------
        userDaoJDBC.getAllUsers();
        //-------------------------------------------
        userDaoJDBC.cleanUsersTable();
        //-------------------------------------------
        userDaoJDBC.dropUsersTable();

        // util.CloseConnection();
    }
}