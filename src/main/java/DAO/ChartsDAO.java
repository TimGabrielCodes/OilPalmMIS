package DAO;

public interface ChartsDAO {
    String getCurrentMonth();

    int getUnmilledBatches();
    int getMilledBatches();

    String getIncomeCostPlot();
    String getIncomeDatePlot();
    String getExpenseCategoryCost();
    String getHarvestandStockPlot();



}
