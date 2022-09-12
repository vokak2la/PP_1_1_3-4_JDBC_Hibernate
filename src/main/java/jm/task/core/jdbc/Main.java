package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();
        //-------------------------------------------
        userService.saveUser("Sasha", "Ivanov", (byte) 11);
        userService.saveUser("Masha", "Petrova", (byte) 22);
        userService.saveUser("Pasha", "Sidorov", (byte) 33);
        userService.saveUser("Ivanushka", "Durachok", (byte) 44);
        //-----------------------------------------------
        userService.getAllUsers();
        //-------------------------------------------
        userService.cleanUsersTable();
        //-------------------------------------------
        userService.dropUsersTable();

    }
}