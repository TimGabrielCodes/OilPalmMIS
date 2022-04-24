package Model;

import java.sql.Date;

public class Mill {
    private int id;
    private Date batchDate;
    private String batchMonth;
    private Integer harvestStock;
    private Double stock_cost;
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

    public Date getBatchDate() {
        return batchDate;
    }

    public void setBatchDate(Date batchDate) {
        this.batchDate = batchDate;
    }

    public String getBatchMonth() {
        return batchMonth;
    }

    public void setBatchMonth(String batchMonth) {
        this.batchMonth = batchMonth;
    }

    public Integer getHarvestStock() {
        return harvestStock;
    }

    public void setHarvestStock(Integer harvestStock) {
        this.harvestStock = harvestStock;
    }

    public Double getStock_cost() {
        return stock_cost;
    }

    public void setStock_cost(Double stock_cost) {
        this.stock_cost = stock_cost;
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
                ", batchDate=" + batchDate +
                ", batchMonth='" + batchMonth + '\'' +
                ", harvestStock=" + harvestStock +
                ", stock_cost=" + stock_cost +
                ", numberOfPresses=" + numberOfPresses +
                ", millingDate=" + millingDate +
                '}';
    }
}
