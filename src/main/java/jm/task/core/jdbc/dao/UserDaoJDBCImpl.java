package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        try ( Connection connection = Util.OpenConnection();
              Statement statement = connection.createStatement()) {

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS user (" +
                    "id BIGINT primary key AUTO_INCREMENT, " +
                    "name VARCHAR(255), " +
                    "lastName VARCHAR(255), " +
                    "age TINYINT)");

            connection.setAutoCommit(false);
            connection.commit(); //

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try ( Connection connection = Util.OpenConnection();
              Statement statement = connection.createStatement()) {

            statement.executeUpdate("DROP TABLE IF EXISTS user");

            connection.setAutoCommit(false);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (   Connection connection = Util.OpenConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO user (name, lastName, age) VALUES (?, ?, ?);")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();

            connection.setAutoCommit(false);
            connection.commit();
            System.out.println("User с именем - " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try ( Connection connection = Util.OpenConnection();
              PreparedStatement statement = connection.prepareStatement("DELETE FROM user WHERE Id = ?")) {

            statement.setLong(1, id);

            statement.executeUpdate();

            connection.setAutoCommit(false);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> listUsers = new ArrayList<>();

        try ( Connection connection = Util.OpenConnection();
              Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM user";
            connection.setAutoCommit(false);

            ResultSet res = statement.executeQuery(sql);

            connection.commit();
            connection.setAutoCommit(true);

            while (res.next()) {
                User user = new User(
                        res.getString("name"), //
                        res.getString("lastName"),
                        (byte) res.getInt("age"));
                user.setId(res.getLong("id"));
                listUsers.add(user);
            }
            System.out.println(listUsers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  listUsers;
    }
        public void cleanUsersTable() {
        try ( Connection connection = Util.OpenConnection();
              Statement statement = connection.createStatement()) {

            String sql = "DELETE FROM user";

            statement.executeUpdate(sql);

            connection.setAutoCommit(false);
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
