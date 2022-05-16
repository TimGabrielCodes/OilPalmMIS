package Model;

import java.sql.Date;

public class Expense {
    private int id;
    private ExpenseCategory expenseCategory;
    private Double amount;
    private String remark;
    private Date date;

    private User logger;


    public Expense() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ExpenseCategory getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getLogger() {
        return logger;
    }

    public void setLogger(User logger) {
        this.logger = logger;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", expenseCategory=" + expenseCategory +
                ", amount=" + amount +
                ", remark='" + remark + '\'' +
                ", date=" + date +
                ", logger=" + logger +
                '}';
    }
}
