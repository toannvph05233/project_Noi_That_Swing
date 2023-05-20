package dao;


import entity.Oder;
import service.StaticVariable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class OderDao {
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    CustomerDao customerDao = new CustomerDao();
    UserDao userDao = new UserDao();

    public List<Oder> getAllOder() {
        try {
            String sql = "select * from oder";
            Connection connection = ConnectMySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Oder> oders = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int total = resultSet.getInt("total");
                int customerId = resultSet.getInt("customerId");
                int userId = resultSet.getInt("userId");
                String date = resultSet.getString("date");

                Oder oder = new Oder(id, customerDao.getById(customerId), userDao.getById(userId), total, format.parse(date));
                oders.add(oder);
            }
            return oders;
        } catch (Exception throwables) {
            throwables.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Oder getOderById(int idO) {
        try {
            String sql = "select * from oder where id = ?";
            Connection connection = ConnectMySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idO);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                int total = resultSet.getInt("total");
                int customerId = resultSet.getInt("customerId");
                int userId = resultSet.getInt("userId");
                String date = resultSet.getString("date");

                Oder oder = new Oder(id, customerDao.getById(customerId), userDao.getById(userId), total, format.parse(date));
                return oder;
            }
            return null;
        } catch (Exception throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public boolean create(Oder oder) {
        try {
            String sql = "INSERT INTO `noithat`.`Oder` (`total`, `date`, `customerId`, `userId`) VALUES (?, ?, ?, ?);";
            Connection connection = ConnectMySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, oder.getTotal());
            preparedStatement.setString(2, format.format(oder.getDate()));
            preparedStatement.setInt(3, oder.getCustomer().getId());
            preparedStatement.setInt(4, oder.getUser().getId());

            return preparedStatement.execute();
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public boolean edit(Oder oder) {
        try {
            String sql = "UPDATE `noithat`.`Oder` SET `total` = ?, `date` = ?, `customerId` = ?, `userId` = ? WHERE (`id` = ?);";
            Connection connection = ConnectMySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, oder.getTotal());
            preparedStatement.setString(2, format.format(oder.getDate()));
            preparedStatement.setInt(3, oder.getCustomer().getId());
            preparedStatement.setInt(4, oder.getUser().getId());
            preparedStatement.setInt(5, oder.getId());

            return preparedStatement.execute();
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            String sql1 = "DELETE FROM `noithat`.`OderDetail` WHERE (`oderid` = ?)";
            String sql2 = "DELETE FROM `noithat`.`Oder` WHERE (`id` = ?)";
            Connection connection = ConnectMySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setInt(1, id);
            return preparedStatement.execute();
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }
}
