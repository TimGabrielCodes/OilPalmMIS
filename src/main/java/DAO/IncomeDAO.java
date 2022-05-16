package DAO;


import Model.Income;

import java.sql.SQLException;
import java.util.List;

public interface IncomeDAO {
    List<Income> get() throws SQLException;

    boolean saveIncome(Income income);

    Income get(int id);

    boolean updateIncome(Income income);

    boolean delete(int id);


}
