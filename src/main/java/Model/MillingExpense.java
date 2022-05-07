package Model;



public class MillingExpense {
    private int id;
    private Double fuel;
    private Double storage;

    private Double harvestStockCost;
    private Double adhocLabour;
    private Double firewood;
    private Double fruitPurchase;
    private Double plantParts;
    private Double others;
    private User logger;

    private OtherExpenses otherExpenses;

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

    public Double getAdhocLabour() {
        return adhocLabour;
    }

    public void setAdhocLabour(Double adhocLabour) {
        this.adhocLabour = adhocLabour;
    }

    public Double getFirewood() {
        return firewood;
    }

    public Double getHarvestStockCost() {
        return harvestStockCost;
    }

    public void setHarvestStockCost(Double harvestStockCost) {
        this.harvestStockCost = harvestStockCost;
    }

    @Override
    public String toString() {
        return "MillingExpense{" +
                "id=" + id +
                ", fuel=" + fuel +
                ", storage=" + storage +
                ", HarvestStockCost=" + harvestStockCost +
                ", adhocLabour=" + adhocLabour +
                ", firewood=" + firewood +
                ", fruitPurchase=" + fruitPurchase +
                ", plantParts=" + plantParts +
                ", others=" + others +
                ", logger=" + logger +
                ", otherExpenses=" + otherExpenses +
                '}';
    }

    public OtherExpenses getOtherExpenses() {
        return otherExpenses;
    }

    public void setOtherExpenses(OtherExpenses otherExpenses) {
        this.otherExpenses = otherExpenses;
    }

    public void setFirewood(Double firewood) {
        this.firewood = firewood;
    }

    public Double getFruitPurchase() {
        return fruitPurchase;
    }

    public void setFruitPurchase(Double fruitPurchase) {
        this.fruitPurchase = fruitPurchase;
    }

    public Double getPlantParts() {
        return plantParts;
    }

    public void setPlantParts(Double plantParts) {
        this.plantParts = plantParts;
    }

    public Double getOthers() {
        return others;
    }

    public void setOthers(Double others) {
        this.others = others;
    }

    public User getLogger() {
        return logger;
    }

    public void setLogger(User logger) {
        this.logger = logger;
    }

}
