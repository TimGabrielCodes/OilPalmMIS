package DAO;

import Model.Harvest;
import Util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HarvestDAOImpl implements HarvestDAO {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    List<Harvest> list = null;
    Harvest harvest = null;
    PreparedStatement preparedStmt = null;


    @Override
    public List<Harvest> get() {

        try {
            list = new ArrayList<>();
            String sql = "select * from harvest";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                harvest = new Harvest();
                setHarvestObject(harvest);

                list.add(harvest);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }

        return list;

    }

    private void setHarvestObject(Harvest harvest) throws SQLException {
        harvest.setId(resultSet.getInt("id"));

        harvest.setDateAdded(resultSet.getDate("dateAdded"));
        harvest.setBatch(new BatchDAOImpl().get(resultSet.getInt("batch")));
        harvest.setStockInBunches(resultSet.getInt("stockInBunches"));
        harvest.setCostPerBunch(resultSet.getDouble("costPerBunch"));
        harvest.setMilled(resultSet.getBoolean("milled"));
        harvest.setLogger(new UserDAOImpl().get(resultSet.getInt("logger")));
        harvest.setOtherCosts(resultSet.getDouble("otherCosts"));
        harvest.setHonorarium(resultSet.getDouble("honorarium"));
    }


    @Override
    public boolean saveHarvest(Harvest harvest) {
        boolean flag = false;
        try {


            String sql = "insert into harvest(batch, stockInBunches, costPerBunch, dateAdded, logger, milled, otherCosts, honorarium) "
                    + "values(" + harvest.getBatch().getId() + ", " + harvest.getStockInBunches() + "," + harvest.getCostPerBunch() + ",'" + harvest.getDateAdded() + "', " + harvest.getLogger().getId() + ", " + harvest.isMilled() + ", " + harvest.getOtherCosts() + ", " + harvest.getHonorarium()+")";
            try {
                connection = DBConnectionUtil.openConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HarvestDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public Harvest get(int id) {
        Harvest harvest = null;
        try {
            harvest = new Harvest();
            String sql = "SELECT * FROM harvest  WHERE id=" + id;
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                setHarvestObject(harvest);

            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HarvestDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return harvest;
    }

    @Override
    public boolean updateHarvest(Harvest harvest) {

        boolean flag = false;

        try {
            String sql = "update harvest set batch=" + harvest.getBatch().getId() + " , stockInBunches=" + harvest.getStockInBunches() + ",costPerBunch=" + harvest.getCostPerBunch() + ", milled =" + harvest.isMilled() + ", dateAdded ='" + harvest.getDateAdded() + "', logger=" + harvest.getLogger().getId() + ", otherCosts=" + harvest.getOtherCosts() + ", honorarium=" + harvest.getHonorarium()+ " where id=" + harvest.getId();
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HarvestDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;

    }

    @Override
    public boolean millHarvest(Harvest harvest) {

        boolean flag = false;

        try {
            String sql = "update harvest set milled = 1 where id=" + harvest.getId();
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HarvestDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;

    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        try {
            String sql = "DELETE FROM harvest WHERE id=" + id;
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HarvestDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    @Override
    public Harvest getHarvestForMill(int batch) {
        Harvest harvest = null;
        try {
            harvest = new Harvest();
            String sql = "SELECT * FROM harvest  WHERE batch=" + batch + " and milled = 0";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                setHarvestObject(harvest);

            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HarvestDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return harvest;
    }


}
