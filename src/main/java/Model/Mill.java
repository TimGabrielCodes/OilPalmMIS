package Model;

import java.sql.Date;

public class Mill {
    private int id;
    private Batch batch;
    private Integer harvestStock;

    private Integer numberOfPresses;
    private Date millingDate;
    private User logger;

    private MillingExpense millingExpense;


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

    public MillingExpense getMillingExpense() {
        return millingExpense;
    }

    public void setMillingExpense(MillingExpense millingExpense) {
        this.millingExpense = millingExpense;
    }

    public User getLogger() {
        return logger;
    }

    public void setLogger(User logger) {
        this.logger = logger;
    }

    @Override
    public String toString() {
        return "Mill{" +
                "id=" + id +
                ", batch=" + batch +
                ", harvestStock=" + harvestStock +
                ", numberOfPresses=" + numberOfPresses +
                ", millingDate=" + millingDate +
                ", logger=" + logger +
                ", millingExpense=" + millingExpense +
                '}';
    }
}
