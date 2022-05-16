package DAO;

import Model.StockItem;

import java.sql.SQLException;
import java.util.List;

public interface StockItemDAO {
    List<StockItem> get() throws SQLException;

    boolean saveStockItem(StockItem stockItem);

    StockItem get(int id);

    boolean updateStockItem(StockItem stockItem);

    boolean delete(int id);

    StockItem get(String name);


}
