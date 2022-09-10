package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {


             Connection connection = Util.OpenConnection();



    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        // Statement - интерфейс для доступа к БД
        try (
                // Connection connection = Util.OpenConnection();
             Statement statement = connection.createStatement()) { // statement для запросов
            //executeUpdate, если в строке есть запрос
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS user (" +    // плюс таблица если ее еще нет
                    "id BIGINT primary key AUTO_INCREMENT, " +
                    "name VARCHAR(255), " +
                    "lastName VARCHAR(255), " +
                    "age TINYINT)");

            connection.setAutoCommit(false); //  статус фиксации в false и завершается методом commit и там же сохраняются изменения
            connection.commit(); //
            System.out.println("Table was created!" + "\n");
            //коннекшон закрывается в ресурсах
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (
               // Connection connection = Util.OpenConnection();
            Statement statement = connection.createStatement()) {
            //executeUpdate, если в строке есть запрос
            statement.executeUpdate("DROP TABLE IF EXISTS user"); // минус таблица если она есть

            connection.setAutoCommit(false); //  статус фиксации в false и завершается методом commit и там же сохраняются изменения
            connection.commit();
            System.out.println("Table was dropped!" + "\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        // PreparedStatement принимает параметры
        try (
               // Connection connection = Util.OpenConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO user (name, lastName, age) VALUES (?, ?, ?);")) {
            statement.setString(1, name); //  значения = ???
            statement.setString(2, lastName);
            statement.setInt(3, age);
            //executeUpdate запрос
            statement.executeUpdate();

            connection.setAutoCommit(false); //  статус фиксации в false и завершается методом commit и там же сохраняются изменения
            connection.commit();
            System.out.println();
            System.out.println("User: " + name + ", " + lastName + " , " + age + " - was added into base"  + "\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (
               // Connection connection = Util.OpenConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM user WHERE Id = ?")) {

            statement.setLong(1, id); // уничтожаем кого-то

            statement.executeUpdate(); //  запрос

            connection.setAutoCommit(false);
            connection.commit();
            System.out.println("User with id " + id + " was deleted!" + "\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> listUsers = new ArrayList<>();

        try {
            // Connection connection = Util.OpenConnection();
            String sql = "SELECT * FROM user";
            connection.setAutoCommit (false);

            Statement statement = connection.createStatement();

            ResultSet res = statement.executeQuery(sql); //ResultSet сохраняет данные из запроса)

            connection.commit(); // непосредственно сам запрос
            connection.setAutoCommit(true);

            while (res.next()) {
                User user = new User(
                        res.getString("name"), //
                        res.getString("lastName"),
                        (byte) res.getInt("age"));
                user.setId(res.getLong("id")); //  idшки из хранилища
                listUsers.add(user);
                System.out.println("Table has - " + user  + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listUsers;
    }

    public void cleanUsersTable() {
        try (
            //    Connection connection = Util.OpenConnection();
             Statement statement = connection.createStatement()) {

            String sql = "DELETE FROM user";

            statement.executeUpdate(sql);

            connection.setAutoCommit(false);
            connection.commit();
            System.out.println("Table was cleaned!"  + "\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
