package Model;

import java.sql.Date;

public class Batch {
    private int id;
    private int batchMonth;
    private int harvestStock;
    private double harvestStockCost;
    private int numberOfPresses;
    private Date millingDate;

    public Batch() {
    }

    public Batch(int id, int batchMonth, int harvestStock, double harvestStockCost, int numberOfPresses, Date millingDate) {
        this.id = id;
        this.batchMonth = batchMonth;
        this.harvestStock = harvestStock;
        this.harvestStockCost = harvestStockCost;
        this.numberOfPresses = numberOfPresses;
        this.millingDate = millingDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBatchMonth() {
        return batchMonth;
    }

    public void setBatchMonth(int batchMonth) {
        this.batchMonth = batchMonth;
    }

    public int getHarvestStock() {
        return harvestStock;
    }

    public void setHarvestStock(int harvestStock) {
        this.harvestStock = harvestStock;
    }

    public double getHarvestStockCost() {
        return harvestStockCost;
    }

    public void setHarvestStockCost(double harvestStockCost) {
        this.harvestStockCost = harvestStockCost;
    }

    public int getNumberOfPresses() {
        return numberOfPresses;
    }

    public void setNumberOfPresses(int numberOfPresses) {
        this.numberOfPresses = numberOfPresses;
    }

    public Date getMillingDate() {
        return millingDate;
    }

    public void setMillingDate(Date millingDate) {
        this.millingDate = millingDate;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "id=" + id +
                ", batchMonth=" + batchMonth +
                ", harvestStock=" + harvestStock +
                ", harvestStockCost=" + harvestStockCost +
                ", numberOfPresses=" + numberOfPresses +
                ", millingDate=" + millingDate +
                '}';
    }
}
