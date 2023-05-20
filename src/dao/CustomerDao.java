package dao;


import entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    public List<Customer> getAll() {
        try {
            String sql = "select * from customer";
            Connection connection = ConnectMySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Customer> customers = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");

                Customer customer = new Customer(id, name, address, phone, email);
                customers.add(customer);
            }
            return customers;
        } catch (Exception throwables) {
            throwables.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Customer getById(int idC) {
        try {
            String sql = "select * from customer where id = ?";
            Connection connection = ConnectMySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idC);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");

                return new Customer(id, name, address, phone, email);
            }
            return null;
        } catch (Exception throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public boolean create(Customer customer) {
        try {
            String sql = "INSERT INTO `noithat`.`Customer` (`name`, `address`, `phone`, `email`) VALUES (?, ?, ?, ?)";
            Connection connection = ConnectMySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setString(4, customer.getEmail());
            return preparedStatement.execute();
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public boolean edit(Customer customer) {
        try {
            String sql = "UPDATE `noithat`.`Customer` SET `name` = ?, `address` = ?, `phone` = ?, `email` = ? WHERE (`id` = ?)";
            Connection connection = ConnectMySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setInt(5, customer.getId());
            return preparedStatement.execute();
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            String sql = "DELETE FROM `noithat`.`customer` WHERE (`id` = ?)";
            Connection connection = ConnectMySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            return preparedStatement.execute();
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }
}
