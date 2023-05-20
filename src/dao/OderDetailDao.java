package dao;

import entity.Oder;
import entity.OderDetail;
import entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OderDetailDao {
        OderDao oderDao = new OderDao();
        ProductDao productDao = new ProductDao();

    public List<OderDetail> getAllOderByOder(int oderId) {
        try {
            String sql = "select * from OderDetail where oderid = ?";
            Connection connection = ConnectMySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, oderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<OderDetail> oderDetails = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int quantity = resultSet.getInt("quantity");
                int oderid = resultSet.getInt("oderid");
                int productid = resultSet.getInt("productid");
                Oder oder = oderDao.getOderById(oderid);
                Product product = productDao.getById(productid);

                OderDetail oderDetail = new OderDetail(id, quantity, product, oder);
                oderDetails.add(oderDetail);
            }
            return oderDetails;
        } catch (Exception throwables) {
            throwables.printStackTrace();
            return new ArrayList<>();
        }
    }

    public OderDetail getOderById(int idO) {
        try {
            String sql = "select * from OderDetail where id = ?";
            Connection connection = ConnectMySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idO);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                int quantity = resultSet.getInt("quantity");
                int oderid = resultSet.getInt("oderid");
                int productid = resultSet.getInt("productid");
                Oder oder = oderDao.getOderById(oderid);
                Product product = productDao.getById(productid);

                OderDetail oderDetail = new OderDetail(id, quantity, product, oder);
                return oderDetail;
            }
            return null;
        } catch (Exception throwables) {
            throwables.printStackTrace();
            return null;
        }
    }


    public boolean create(OderDetail oderDetail, int idOder, int idProduct) {
        try {
            String sql = "INSERT INTO `noithat`.`OderDetail` (`quantity`, `oderid`, `productid`) VALUES (?, ?, ?);";
            Connection connection = ConnectMySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, oderDetail.getQuantity());
            preparedStatement.setInt(2,idOder);
            preparedStatement.setInt(3, idProduct);

            return preparedStatement.execute();
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public boolean edit(OderDetail oderDetail, int idOder, int idProduct) {
        try {
            String sql = "UPDATE `noithat`.`OderDetail` SET `quantity` = ?, `oderid` = ?, `productid` = ? WHERE (`id` = ?);";
            Connection connection = ConnectMySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, oderDetail.getQuantity());
            preparedStatement.setInt(2,idOder);
            preparedStatement.setInt(3, idProduct);
            preparedStatement.setInt(4, oderDetail.getId());
            return preparedStatement.execute();
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            String sql = "DELETE FROM `noithat`.`OderDetail` WHERE (`id` = ?)";
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
