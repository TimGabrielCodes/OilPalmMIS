package Model;

public class MillingExpense {

    private int id;
    private Double fuel;
    private Double storage;
    private Double harvestStockCost;
    private Double adhocLabour;
    private Double firewood;

    private Double plantParts;
    private User logger;
    private Mill mill;


    public MillingExpense() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getFuel() {
        return fuel;
    }

    public void setFuel(Double fuel) {
        this.fuel = fuel;
    }

    public Double getStorage() {
        return storage;
    }

    public void setStorage(Double storage) {
        this.storage = storage;
    }

    public Double getHarvestStockCost() {
        return harvestStockCost;
    }

    public void setHarvestStockCost(Double harvestStockCost) {
        this.harvestStockCost = harvestStockCost;
    }

    public Double getAdhocLabour() {
        return adhocLabour;
    }

    public void setAdhocLabour(Double adhocLabour) {
        this.adhocLabour = adhocLabour;
    }

    public Double getFirewood() {
        return firewood;
    }

    public void setFirewood(Double firewood) {
        this.firewood = firewood;
    }

    public Double getPlantParts() {
        return plantParts;
    }

    public void setPlantParts(Double plantParts) {
        this.plantParts = plantParts;
    }

    public User getLogger() {
        return logger;
    }

    public void setLogger(User logger) {
        this.logger = logger;
    }

    public Mill getMill() {
        return mill;
    }

    public void setMill(Mill mill) {
        this.mill = mill;
    }


    @Override
    public String toString() {
        return "MillingExpense{" +
                "id=" + id +
                ", fuel=" + fuel +
                ", storage=" + storage +
                ", harvestStockCost=" + harvestStockCost +
                ", adhocLabour=" + adhocLabour +
                ", firewood=" + firewood +
                ", plantParts=" + plantParts +
                ", logger=" + logger +
                ", mill=" + mill +
                '}';
    }
}
