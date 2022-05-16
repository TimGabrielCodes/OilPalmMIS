package DAO;

import Model.OtherExpenses;

import java.sql.SQLException;
import java.util.List;

public interface OtherExpenseDAO {
    List<OtherExpenses> get() throws SQLException;

    boolean saveOtherExpense(OtherExpenses otherExpenses);

    OtherExpenses get(int id);

    boolean updateOtherExpense(OtherExpenses otherExpenses);

    boolean delete(int id);


}
