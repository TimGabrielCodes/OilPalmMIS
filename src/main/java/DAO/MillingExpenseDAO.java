package DAO;

import Model.Mill;
import Model.MillingExpense;

import java.sql.SQLException;
import java.util.List;

public interface MillingExpenseDAO {
    List<MillingExpense> get() throws SQLException;

    boolean saveMillingExpense(MillingExpense millingExpense);

    MillingExpense get(int id);

    MillingExpense get(Mill mill);

    boolean updateMillingExpense(MillingExpense millingExpense);

    boolean delete(int id);


}
