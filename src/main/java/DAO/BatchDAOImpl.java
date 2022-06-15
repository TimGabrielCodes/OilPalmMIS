package DAO;

import Model.Batch;
import Model.Vendor;
import Util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BatchDAOImpl implements BatchDAO {
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
                batch.setBatchName(resultSet.getString("batchName"));
                batch.setBatchMonth(resultSet.getString("batchMonth"));
                batch.setBatchDate(resultSet.getDate("batchDate"));
                batch.setLogger(new UserDAOImpl().get(resultSet.getInt("logger")));
                batch.setHarvested(resultSet.getBoolean("harvested"));

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


            String sql = "insert into batch(batchName, batchMonth, batchDate, logger, harvested) "
                    + "values('" + batch.getBatchName() + "', '" + batch.getBatchMonth() + "','" + batch.getBatchDate() + "'," + batch.getLogger().getId() +","+  batch.isHarvested() +")";
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
            String sql = "SELECT * FROM batch  WHERE id=" + id;
            openConnection(batch, sql);

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BatchDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return batch;
    }

    @Override
    public Batch get(String name) {
        Batch batch = null;
        try {
            batch = new Batch();
            String sql = "SELECT * FROM batch  WHERE batchName='" + name + "'";
            openConnection(batch, sql);

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BatchDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return batch;
    }

    private void openConnection(Batch batch, String sql) throws ClassNotFoundException, SQLException {
        connection = DBConnectionUtil.openConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            batch.setId(resultSet.getInt("id"));
            batch.setBatchName(resultSet.getString("batchName"));
            batch.setBatchMonth(resultSet.getString("batchMonth"));
            batch.setBatchDate(resultSet.getDate("batchDate"));
            batch.setLogger(new UserDAOImpl().get(resultSet.getInt("logger")));
            batch.setHarvested(resultSet.getBoolean("harvested"));



        }
    }

    @Override
    public boolean updateBatch(Batch batch) {

        boolean flag = false;

        try {
            String sql = "update batch set batchName='" + batch.getBatchName() + "',batchMonth='" + batch.getBatchMonth() + "',batchDate='" + batch.getBatchDate() + "',logger =" + batch.getLogger().getId() + " where id=" + batch.getId();
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
    public void harvestBatch(Batch batch) {


        try {
            String sql = "update batch set harvested= 1  where id=" + batch.getId();
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BatchDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        try {
            String sql = "DELETE FROM batch WHERE id=" + id;
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
