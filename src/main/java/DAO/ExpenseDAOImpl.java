package DAO;

import Model.Mill;
import Model.Expense;
import Util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExpenseDAOImpl implements ExpenseDAO{

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    List<Expense> list = null;
    Expense expense = null;
    PreparedStatement preparedStmt = null;

    @Override
    public List<Expense> get() throws SQLException {

        try {
            list = new ArrayList<>();
            String sql = "select * from expense ";
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                expense = new Expense();
                setExpenseObject(expense);


                list.add(expense);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }

        return list;
    }

    private void setExpenseObject(Expense expense) throws SQLException {
        expense.setId(resultSet.getInt("id"));
        expense.setFuel(resultSet.getDouble("fuel"));
        expense.setStorage(resultSet.getDouble("storage"));
        expense.setHarvestStockCost(resultSet.getDouble("harvestStockCost"));
        expense.setAdhocLabour(resultSet.getDouble("adhocLabour"));
        expense.setFirewood(resultSet.getDouble("firewood"));
        expense.setFruitPurchase(resultSet.getDouble("fruitPurchase"));
        expense.setPlantParts(resultSet.getDouble("plantParts"));
        expense.setLogger(new UserDAOImpl().get(resultSet.getInt("logger")));
        expense.setMill(new MillDAOImpl().get(resultSet.getInt("mill")));


    }

    @Override
    public boolean saveExpense(Expense expense) {

        boolean flag = false;
        try {


            String sql = "insert into expense(fuel, storage, harvestStockCost, adhocLabour, firewood, fruitPurchase, plantParts, logger, mill) "
                    + "values(" +expense.getFuel() + ", " + expense.getStorage() + "," + expense.getHarvestStockCost() + "," + expense.getAdhocLabour() + ","+ expense.getFirewood()
                    + "," +expense.getFruitPurchase()+ ", "+ expense.getPlantParts() + "," + expense.getLogger().getId() +","+ expense.getMill().getId()  + ")";
            try {
                connection = DBConnectionUtil.openConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ExpenseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public Expense get(int id) {
        Expense expense = null;
        try {
            expense = new Expense();
            String sql = "SELECT * FROM expense  WHERE id=" + id;
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                setExpenseObject(expense);

            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExpenseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return expense;
    }    public Expense get(Mill mill) {
        Expense expense = null;
        try {
            expense = new Expense();
            String sql = "SELECT * FROM expense  WHERE mill=" + mill.getId();
            connection = DBConnectionUtil.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                setExpenseObject(expense);

            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExpenseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return expense;
    }

    @Override
    public boolean updateExpense(Expense expense) {

        boolean flag = false;

        try {
            String sql = "update expense set fuel=" + expense.getFuel() + " ,storage=" + expense.getStorage() + ",harvestStockCost="
                    + expense.getHarvestStockCost() + ",adhocLabour =" +expense.getAdhocLabour()
                    + ", firewood ="+ expense.getFirewood()+", fruitPurchase="+ expense.getFruitPurchase()
                    + ", plantParts=" +  expense.getPlantParts() + ", logger="+ expense.getLogger()+ " where id=" + expense.getId();
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExpenseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        try {
            String sql = "DELETE FROM expense WHERE id=" + id;
            connection = DBConnectionUtil.openConnection();
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.executeUpdate();
            flag = true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExpenseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
}
