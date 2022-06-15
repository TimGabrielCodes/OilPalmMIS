package Model;

public class StockItem {

    private int id;
    private String name;
    private Double sellingPrice;
    private ProductUnit productUnit;

    private Batch batch;

    public void setProductUnit(ProductUnit productUnit) {
        this.productUnit = productUnit;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    private Integer quantity;



    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    private User logger;

    public StockItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public ProductUnit getProductUnit() {
        return productUnit;
    }

    public void setStorageUnit(ProductUnit productUnit) {
        this.productUnit = productUnit;
    }

    @Override
    public String toString() {
        return "StockItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sellingPrice=" + sellingPrice +
                ", productUnit=" + productUnit +
                ", batch=" + batch +
                ", quantity=" + quantity +
                ", logger=" + logger +
                '}';
    }

    public User getLogger() {
        return logger;
    }

    public void setLogger(User logger) {
        this.logger = logger;
    }

}
