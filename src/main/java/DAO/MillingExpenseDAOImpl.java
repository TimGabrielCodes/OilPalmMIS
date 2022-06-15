package DAO;

import Model.Mill;
import Model.MillingExpense;
import Util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MillingExpenseDAOImpl implements MillingExpenseDAO {

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    List<MillingExpense> list = null;
    MillingExpense millingExpense = null;
    PreparedStatement preparedStmt = null;

    @Override
    public List<MillingExpense> get() throws SQLException {

        try {
            list = new ArrayList<>();
            String sql = "select * from millingExpense ";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                millingExpense = new MillingExpense();
                setMillingExpenseObject(millingExpense);


                list.add(millingExpense);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }

        return list;
    }

    private void setMillingExpenseObject(MillingExpense millingExpense) throws SQLException {
        millingExpense.setId(resultSet.getInt("id"));
        millingExpense.setFuel(resultSet.getDouble("fuel"));
        millingExpense.setStorage(resultSet.getDouble("storage"));
        millingExpense.setHarvestStockCost(resultSet.getDouble("harvestStockCost"));
        millingExpense.setAdhocLabour(resultSet.getDouble("adhocLabour"));
        millingExpense.setFirewood(resultSet.getDouble("firewood"));
//        millingExpense.setFruitPurchase(resultSet.getDouble("fruitPurchase"));
        millingExpense.setPlantParts(resultSet.getDouble("plantParts"));
        millingExpense.setLogger(new UserDAOImpl().get(resultSet.getInt("logger")));
        millingExpense.setMill(new MillDAOImpl().get(resultSet.getInt("mill")));
//        millingExpense.setHonorarium(resultSet.getDouble("honorarium"));


    }

    @Override
    public boolean saveMillingExpense(MillingExpense millingExpense) {

        boolean flag = false;
        try {


            String sql = "insert into millingExpense(fuel, storage, harvestStockCost, adhocLabour, firewood,  plantParts, logger, mill) "
                    + "values(" + millingExpense.getFuel() + ", " + millingExpense.getStorage() + "," + millingExpense.getHarvestStockCost() + "," + millingExpense.getAdhocLabour() + "," + millingExpense.getFirewood()
                    + ", " + millingExpense.getPlantParts() + "," + millingExpense.getLogger().getId() + "," + millingExpense.getMill().getId() + ")";
            try {
                connection = DBConnectionUtil.openConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MillingExpenseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public MillingExpense get(int id) {
        MillingExpense millingExpense = null;
        try {
            millingExpense = new MillingExpense();
            String sql = "SELECT * FROM millingExpense  WHERE id=" + id;
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                setMillingExpenseObject(millingExpense);

            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MillingExpenseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return millingExpense;
    }

    public MillingExpense get(Mill mill) {
        MillingExpense millingExpense = null;
        try {
            millingExpense = new MillingExpense();
            String sql = "SELECT * FROM millingExpense  WHERE mill=" + mill.getId();
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                setMillingExpenseObject(millingExpense);

            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MillingExpenseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return millingExpense;
    }

    @Override
    public boolean updateMillingExpense(MillingExpense millingExpense) {

        boolean flag = false;

        try {
            String sql = "update millingExpense set fuel=" + millingExpense.getFuel() + " ,storage=" + millingExpense.getStorage() + ",harvestStockCost="
                    + millingExpense.getHarvestStockCost() + ",adhocLabour =" + millingExpense.getAdhocLabour()
                    + ", firewood =" + millingExpense.getFirewood() +", plantParts=" + millingExpense.getPlantParts() + ", logger=" + millingExpense.getLogger() +" where id=" + millingExpense.getId();
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MillingExpenseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        try {
            String sql = "DELETE FROM millingExpense WHERE id=" + id;
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MillingExpenseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
}
