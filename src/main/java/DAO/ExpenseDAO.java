package DAO;

import Model.Expense;
import Model.ExpenseCategory;

import java.sql.SQLException;
import java.util.List;


public interface ExpenseDAO {
    List<Expense> get() throws SQLException;

    boolean  saveExpense(Expense expense);

    Expense get(int id);


    boolean updateExpense(Expense expense);

    boolean delete(int id);






}
