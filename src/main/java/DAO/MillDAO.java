package DAO;

import Model.Batch;
import Model.Mill;

import java.sql.SQLException;
import java.util.List;

public interface MillDAO {
    List<Mill> get() throws SQLException;

    boolean saveMill(Mill mill);

    Mill get(int id);

    Mill getByBatch(int id);

    Mill get(Batch batch);

    boolean updateMill(Mill mill);

    boolean delete(int id);


}
