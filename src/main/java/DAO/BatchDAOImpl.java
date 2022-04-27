package DAO;

import Model.Batch;
import Model.Vendor;
import Util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BatchDAOImpl implements BatchDAO{
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    List<Batch> list = null;
    List<Vendor> vendorList = null;
    Batch batch = null;
    Vendor vendor = null;
    PreparedStatement preparedStmt = null;

    @Override
    public List<Batch> get() throws SQLException {

        try {
            list = new ArrayList<Batch>();
            String sql = "select * from batch ";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                batch = new Batch();
                //  batch.setRole(resultSet.getString("role"));
batch.setId(resultSet.getInt("id"));
batch.setBatchMonth(resultSet.getInt("batchMonth"));
batch.setHarvestStock(resultSet.getInt("harvestStock"));
batch.setHarvestStockCost(resultSet.getDouble("harvestStockCost"));
batch.setNumberOfPresses(resultSet.getInt("numberOfPresses"));
batch.setMillingDate(resultSet.getDate("millingDate"));






                list.add(batch);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }

        return list;

    }



    @Override
    public boolean saveBatch(Batch batch) {
        boolean flag = false;
        try {


            String sql = "insert into batch(batchMonth, harvestStock, harvestStockCost, numberOfPresses, millingDate) "
                    + "values(" +batch.getBatchMonth() + "," + batch.getHarvestStock() + "," + batch.getHarvestStockCost() + "," + batch.getNumberOfPresses() + "," + batch.getMillingDate() + ")";
            try {
                connection = DBConnectionUtil.openConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BatchDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public Batch get(int id) {
        Batch batch = null;
        try {
            batch = new Batch();
            String sql = "SELECT * FROM batch  WHERE batch_id=" + id;
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                batch.setId(resultSet.getInt("id"));
                batch.setBatchMonth(resultSet.getInt("batchMonth"));
                batch.setHarvestStock(resultSet.getInt("harvestStock"));
                batch.setHarvestStockCost(resultSet.getDouble("harvestStockCost"));
                batch.setNumberOfPresses(resultSet.getInt("numberOfPresses"));
                batch.setMillingDate(resultSet.getDate("millingDate"));

            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BatchDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return batch;
    }

    @Override
    public boolean updateBatch(Batch batch) {

        boolean flag = false;

        try {
            String sql = "update batch set batchMonth=" + batch.getBatchMonth() + ", harvestStock=" + batch.getHarvestStock() + ", harvestStockCost =" + batch.getHarvestStockCost() + ", numberOfPresses= " + batch.getNumberOfPresses()+ ", millingDate="  + batch.getMillingDate() +" where id=" + batch.getId() ;
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BatchDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;

    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        try {
            String sql = "DELETE FROM batch WHERE batch_id=" + id;
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BatchDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }






}
