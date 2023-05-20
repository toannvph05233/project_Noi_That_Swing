package dao;


import entity.Customer;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public User login(String username, String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            Connection connection = ConnectMySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            User account = null;

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username1 = resultSet.getString("username");
                String password1 = resultSet.getString("password");
                String role = resultSet.getString("role");
                account = new User(id,username1, password1,role);
            }
            return account;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public User checkUserNam(String username) {
        try {
            String sql = "select * from user where username = ?";
            Connection connection = ConnectMySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            User account = null;

            if (resultSet.next()) {
                String username1 = resultSet.getString("username");
                String password1 = resultSet.getString("password");
                account = new User(username1, password1);
            }
            return account;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public User getById(int idC) {
        try {
            String sql = "select * from user where id = ?";
            Connection connection = ConnectMySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idC);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");

                return new User(id, username, password, role);
            }
            return null;
        } catch (Exception throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public boolean create(User user) {
        try {
            String sql = "INSERT INTO `noithat`.`user` (`username`, `password`, `role`) VALUES (?, ?, ?);";
            Connection connection = ConnectMySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, "staff");
            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
}
