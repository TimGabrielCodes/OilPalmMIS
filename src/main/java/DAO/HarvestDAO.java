package DAO;

import Model.Harvest;

import java.sql.SQLException;
import java.util.List;

public interface HarvestDAO {
    List<Harvest> get() throws SQLException;

    boolean  saveHarvest(Harvest harvest);

    Harvest get(int id);

    boolean updateHarvest(Harvest harvest);

    boolean delete(int id);


    Harvest getHarvestForMill(int batch);

    boolean millHarvest(Harvest harvest);
}
