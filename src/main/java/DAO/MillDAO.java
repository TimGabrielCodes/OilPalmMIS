package DAO;

import Model.Mill;

import java.sql.SQLException;
import java.util.List;

public interface MillDAO {
    List<Mill> get() throws SQLException;

    boolean  saveMill(Mill mill);

    Mill get(int id);

    boolean updateMill(Mill mill);

    boolean delete(int id);






}
