package DAO;

import Model.Batch;

import java.sql.SQLException;
import java.util.List;

public interface BatchDAO {
    List<Batch> get() throws SQLException;

    boolean saveBatch(Batch batch);

    Batch get(int id);

    boolean updateBatch(Batch batch);

    void harvestBatch(Batch batch);

    boolean delete(int id);

    Batch get(String name);


}
