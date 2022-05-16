package Model;

import java.sql.Date;

public class Batch {
    private int id;
    private String batchName;
    private String batchMonth;
    private Date batchDate;
    private User logger;

    public Batch() {
    }

    @Override
    public String toString() {
        return "Batch{" +
                "id=" + id +
                ", batchName='" + batchName + '\'' +
                ", batchMonth=" + batchMonth +
                ", batchDate=" + batchDate +
                ", logger=" + logger +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getBatchMonth() {
        return batchMonth;
    }

    public void setBatchMonth(String batchMonth) {
        this.batchMonth = batchMonth;
    }

    public Date getBatchDate() {
        return batchDate;
    }

    public void setBatchDate(Date batchDate) {
        this.batchDate = batchDate;
    }

    public User getLogger() {
        return logger;
    }

    public void setLogger(User logger) {
        this.logger = logger;
    }


}