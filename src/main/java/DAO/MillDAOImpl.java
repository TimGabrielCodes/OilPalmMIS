package DAO;

import Model.Batch;
import Model.Mill;
import Util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MillDAOImpl implements MillDAO {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    List<Mill> list = null;
    Mill mill = null;
    PreparedStatement preparedStmt = null;

    @Override
    public List<Mill> get() throws SQLException {

        try {
            list = new ArrayList<>();
            String sql = "select * from mill ";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                mill = new Mill();
                setMillObject(mill);


                list.add(mill);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }

        return list;

    }

    private void setMillObject(Mill mill) throws SQLException {
        mill.setId(resultSet.getInt("id"));
        mill.setBatch(new BatchDAOImpl().get(resultSet.getInt("batch")));
        mill.setHarvestStock(resultSet.getInt("harvestStock"));
        mill.setNumberOfPresses(resultSet.getInt("numberOfPresses"));
        mill.setMillingDate(resultSet.getDate("millingDate"));
        mill.setLogger(new UserDAOImpl().get(resultSet.getInt("logger")));

    }


    @Override
    public boolean saveMill(Mill mill) {
        boolean flag = false;
        try {


            String sql = "insert into mill(batch, harvestStock, numberOfPresses, millingDate, logger) "
                    + "values(" + mill.getBatch().getId() + ", " + mill.getHarvestStock() + "," + mill.getNumberOfPresses() + ",'" + mill.getMillingDate() + "', " + mill.getLogger().getId() + ")";
            try {
                connection = DBConnectionUtil.openConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MillDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public Mill get(int id) {
        Mill mill = null;
        try {
            mill = new Mill();
            String sql = "SELECT * FROM mill  WHERE id=" + id + " LIMIT 1";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                setMillObject(mill);


            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MillDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mill;
    }

    @Override
    public Mill getByBatch(int id) {
        Mill mill = null;
        try {
            mill = new Mill();
            String sql = "SELECT * FROM mill  WHERE batch=" + id + " LIMIT 1";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                setMillObject(mill);


            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MillDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mill;
    }

    @Override
    public Mill get(Batch batch) {
        Mill mill = null;
        try {
            mill = new Mill();
            String sql = "SELECT * FROM mill  WHERE batch=" + batch.getId();
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                setMillObject(mill);

            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MillDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mill;
    }

    @Override
    public boolean updateMill(Mill mill) {

        boolean flag = false;

        try {
            String sql = "update mill set batch=" + mill.getBatch().getId() + " ,harvestStock=" + mill.getHarvestStock() + ",numberOfPresses =" + mill.getNumberOfPresses() + ", millingDate ='" + mill.getMillingDate() + "', logger=" + mill.getLogger().getId() + " where id=" + mill.getId();
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MillDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;

    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        try {
            String sql = "DELETE FROM mill WHERE id=" + id;
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MillDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }


}
