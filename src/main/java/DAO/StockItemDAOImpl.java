package DAO;

import Model.ProductUnit;
import Model.StockItem;
import Model.Vendor;
import Util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StockItemDAOImpl implements StockItemDAO {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    List<StockItem> list = null;
    List<Vendor> vendorList = null;
    StockItem stockItem = null;
    Vendor vendor = null;
    PreparedStatement preparedStmt = null;

    @Override
    public List<StockItem> get() throws SQLException {

        try {
            list = new ArrayList<StockItem>();
            String sql = "select * from stockItem ";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                stockItem = new StockItem();
                //  stockItem.setRole(resultSet.getString("role"));
                stockItem.setId(resultSet.getInt("id"));
                stockItem.setName(resultSet.getString("name"));
                stockItem.setSellingPrice(resultSet.getDouble("sellingPrice"));
                stockItem.setStorageUnit(ProductUnit.valueOf(resultSet.getString("productUnit")));
                stockItem.setLogger(new UserDAOImpl().get(resultSet.getInt("logger")));
                stockItem.setQuantity(resultSet.getInt("quantity"));


                list.add(stockItem);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }

        return list;

    }


    @Override
    public boolean saveStockItem(StockItem stockItem) {
        boolean flag = false;
        try {


            String sql = "insert into stockItem(name, sellingPrice, storageUnit, logger, quantity) "
                    + "values('" + stockItem.getName() + "', " + stockItem.getSellingPrice() + ",'" + stockItem.getProductUnit() + "'," + stockItem.getLogger().getId() + "," + stockItem.getQuantity() + ")";
            try {
                connection = DBConnectionUtil.openConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StockItemDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public StockItem get(int id) {
        StockItem stockItem = null;
        try {
            stockItem = new StockItem();
            String sql = "SELECT * FROM stockItem  WHERE id=" + id;
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                //  stockItem.setRole(resultSet.getString("role"));
                stockItem.setId(resultSet.getInt("id"));
                stockItem.setName(resultSet.getString("name"));
                stockItem.setSellingPrice(resultSet.getDouble("sellingPrice"));
                stockItem.setStorageUnit(ProductUnit.valueOf(resultSet.getString("storageUnit")));
                stockItem.setLogger(new UserDAOImpl().get(resultSet.getInt("logger")));
                stockItem.setQuantity(resultSet.getInt("quantity"));


            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StockItemDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stockItem;
    }

    @Override
    public StockItem get(String name) {
        StockItem stockItem = null;
        try {
            stockItem = new StockItem();
            String sql = "SELECT * FROM stockItem  WHERE stockItemName='" + name + "'";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                //  stockItem.setRole(resultSet.getString("role"));
                stockItem.setId(resultSet.getInt("id"));
                stockItem.setName(resultSet.getString("name"));
                stockItem.setSellingPrice(resultSet.getDouble("sellingPrice"));
                stockItem.setStorageUnit(ProductUnit.valueOf(resultSet.getString("storageUnit")));
                stockItem.setLogger(new UserDAOImpl().get(resultSet.getInt("logger")));
                stockItem.setQuantity(resultSet.getInt("quantity"));


            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StockItemDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stockItem;
    }

    @Override
    public boolean updateStockItem(StockItem stockItem) {

        boolean flag = false;

        try {
            String sql = "update stockItem set name='" + stockItem.getName() + "',sellingPrice=" + stockItem.getSellingPrice() + ",storageUnit='" + stockItem.getProductUnit() + "',logger =" + stockItem.getLogger().getId() + " where id=" + stockItem.getId();
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StockItemDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;

    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        try {
            String sql = "DELETE FROM stockItem WHERE id=" + id;
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StockItemDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }


}
