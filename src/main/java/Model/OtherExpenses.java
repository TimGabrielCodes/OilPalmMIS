package Model;

public class OtherExpenses {
    private int id;
    private MillingExpense parentMillingExpense;
    private Double fieldCutting;
    private Double bushCutting;
    private Double palmPruning;
    private Double harvestCost;
    private Double honorarium;

    public OtherExpenses() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MillingExpense getParentExpense() {
        return parentMillingExpense;
    }

    public void setParentExpense(MillingExpense parentMillingExpense) {
        this.parentMillingExpense = parentMillingExpense;
    }

    public Double getFieldCutting() {
        return fieldCutting;
    }

    public void setFieldCutting(Double fieldCutting) {
        this.fieldCutting = fieldCutting;
    }

    public Double getBushCutting() {
        return bushCutting;
    }

    public void setBushCutting(Double bushCutting) {
        this.bushCutting = bushCutting;
    }

    public Double getPalmPruning() {
        return palmPruning;
    }

    public void setPalmPruning(Double palmPruning) {
        this.palmPruning = palmPruning;
    }

    public Double getHarvestCost() {
        return harvestCost;
    }

    public void setHarvestCost(Double harvestCost) {
        this.harvestCost = harvestCost;
    }

    public Double getHonorarium() {
        return honorarium;
    }

    public void setHonorarium(Double honorarium) {
        this.honorarium = honorarium;
    }

    @Override
    public String toString() {
        return "OtherExpenses{" +
                "id=" + id +
                ", parentMillingExpense=" + parentMillingExpense +
                ", fieldCutting=" + fieldCutting +
                ", bushCutting=" + bushCutting +
                ", palmPruning=" + palmPruning +
                ", harvestCost=" + harvestCost +
                ", honorarium=" + honorarium +
                '}';
    }
}
