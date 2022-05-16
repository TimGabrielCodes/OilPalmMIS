package DAO;

import Model.OtherExpenses;

import java.sql.SQLException;
import java.util.List;

public class OtherExpensesDAOImpl implements OtherExpenseDAO {
    @Override
    public List<OtherExpenses> get() throws SQLException {
        return null;
    }

    @Override
    public boolean saveOtherExpense(OtherExpenses otherExpenses) {
        return false;
    }

    @Override
    public OtherExpenses get(int id) {
        return null;
    }

    @Override
    public boolean updateOtherExpense(OtherExpenses otherExpenses) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
