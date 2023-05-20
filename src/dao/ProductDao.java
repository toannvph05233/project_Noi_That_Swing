package dao;


import entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");


    public List<Product> getAll() {
        try {
            String sql = "select * from product";
            Connection connection = ConnectMySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Product> products = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                String content = resultSet.getString("content");
                String date = resultSet.getString("date");

                Product product = new Product(id, name, content, price, quantity, format.parse(date));
                products.add(product);
            }
            return products;
        } catch (Exception throwables) {
            throwables.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Product getById(int idP) {
        try {
            String sql = "select * from product where id = ?";
            Connection connection = ConnectMySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idP);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                String content = resultSet.getString("content");
                String date = resultSet.getString("date");

                Product product = new Product(id, name, content, price, quantity, format.parse(date));
                return product;
            }
            return null;
        } catch (Exception throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public boolean create(Product product) {
        try {
            String sql = "INSERT INTO `noithat`.`Product` (`name`, `price`, `quantity`, `content`, `date`) VALUES (?, ?, ?, ?, ?);";
            Connection connection = ConnectMySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getContent());
            preparedStatement.setString(5, format.format(product.getDate()));

            return preparedStatement.execute();
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public boolean edit(Product product) {
        try {
            String sql = "UPDATE `noithat`.`Product` SET `name` = ?, `price` = ?, `quantity` = ?, `content` = ?, `date` = ? WHERE (`id` = ?);";
            Connection connection = ConnectMySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getContent());
            preparedStatement.setString(5, format.format(product.getDate()));
            preparedStatement.setInt(6, product.getId());
            return preparedStatement.execute();
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            String sql = "DELETE FROM `noithat`.`Product` WHERE (`id` = ?)";
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
