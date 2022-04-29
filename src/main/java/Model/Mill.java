package Model;

import java.sql.Date;

public class Mill {
    private int id;
    private Batch batch;
    private Integer harvestStock;
    private Double stockCost;
    private Integer numberOfPresses;
    private Date millingDate;


    public Mill() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public Integer getHarvestStock() {
        return harvestStock;
    }

    public void setHarvestStock(Integer harvestStock) {
        this.harvestStock = harvestStock;
    }

    public Double getStockCost() {
        return stockCost;
    }

    public void setStockCost(Double stockCost) {
        this.stockCost = stockCost;
    }

    public Integer getNumberOfPresses() {
        return numberOfPresses;
    }

    public void setNumberOfPresses(Integer numberOfPresses) {
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
        return "Mill{" +
                "id=" + id +
                ", batch=" + batch +
                ", harvestStock=" + harvestStock +
                ", stock_cost=" + stockCost +
                ", numberOfPresses=" + numberOfPresses +
                ", millingDate=" + millingDate +
                '}';
    }
}
