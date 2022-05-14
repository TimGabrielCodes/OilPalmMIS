package Model;

import java.sql.Date;

public class Harvest {

    private int id;
    private User logger;

    private Batch batch;

    private Double harvestStockCost;
    private int stockInBunches;

    private Double costPerBunch;

    private Date dateAdded;

    private boolean milled;


    public Harvest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getLogger() {
        return logger;
    }

    public void setLogger(User logger) {
        this.logger = logger;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public int getStockInBunches() {
        return stockInBunches;
    }

    public void setStockInBunches(int stockInBunches) {
        this.stockInBunches = stockInBunches;
    }

    public Double getCostPerBunch() {
        return costPerBunch;
    }

    public void setCostPerBunch(Double costPerBunch) {
        this.costPerBunch = costPerBunch;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public Double getHarvestStockCost() {
        return (this.costPerBunch * this.stockInBunches);
    }


    @Override
    public String toString() {
        return "Harvest{" +
                "id=" + id +
                ", logger=" + logger +
                ", batch=" + batch +
                ", harvestStockCost=" + harvestStockCost +
                ", stockInBunches=" + stockInBunches +
                ", costPerBunch=" + costPerBunch +
                ", dateAdded=" + dateAdded +
                ", milled=" + milled +
                '}';
    }

    public void setHarvestStockCost(Double harvestStockCost) {
        this.harvestStockCost = harvestStockCost;
    }

    public boolean isMilled() {
        return milled;
    }

    public void setMilled(boolean milled) {
        this.milled = milled;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

}
