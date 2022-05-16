package DAO;

import Model.Expense;
import Model.ExpenseCategory;
import Util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExpenseDAOImpl implements ExpenseDAO {

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
        expense.setDate(resultSet.getDate("date"));
        expense.setExpenseCategory(ExpenseCategory.valueOf(resultSet.getString("expenseCategory")));
        expense.setAmount(resultSet.getDouble("amount"));
        expense.setRemark(resultSet.getString("remark"));
        expense.setLogger(new UserDAOImpl().get(resultSet.getInt("logger")));


    }

    @Override
    public boolean saveExpense(Expense expense) {

        boolean flag = false;
        try {


            String sql = "insert into expense(expenseCategory, amount, remark, date, logger) "
                    + "values('" + expense.getExpenseCategory() + "'," + expense.getAmount() + ",'" + expense.getRemark() + "','" + expense.getDate() + "'," + expense.getLogger().getId() + ")";
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
    }

    @Override
    public boolean updateExpense(Expense expense) {

        boolean flag = false;

        try {
            String sql = "update expense set expenseCategory='" + expense.getExpenseCategory() + "' ,amount=" + expense.getAmount() + ",remark='"
                    + expense.getRemark() + "',date ='" + expense.getDate() + "' where id=" + expense.getId();
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
