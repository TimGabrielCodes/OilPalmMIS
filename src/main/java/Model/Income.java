package Model;

import java.sql.Date;

public class Income {
    private int id;
    private IncomeType incomeType;
    private Double amount;
    private String receivedFrom;
    private User logger;
    private Date date;

    private ProductUnit productUnit;

    private String remark;

    public Income() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IncomeType getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(IncomeType incomeType) {
        this.incomeType = incomeType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getReceivedFrom() {
        return receivedFrom;
    }

    public void setReceivedFrom(String receivedFrom) {
        this.receivedFrom = receivedFrom;
    }

    public User getLogger() {
        return logger;
    }

    public void setLogger(User logger) {
        this.logger = logger;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public ProductUnit getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(ProductUnit productUnit) {
        this.productUnit = productUnit;
    }

    @Override
    public String toString() {
        return "Income{" +
                "id=" + id +
                ", incomeType=" + incomeType +
                ", amount=" + amount +
                ", receivedFrom='" + receivedFrom + '\'' +
                ", logger=" + logger +
                ", date=" + date +
                ", productUnit=" + productUnit +
                ", remark='" + remark + '\'' +
                '}';
    }
}
