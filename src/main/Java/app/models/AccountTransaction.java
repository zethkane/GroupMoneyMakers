package app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class AccountTransaction {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long transactionId;
    private AccountTransactionType type;
    private double amount;
    private Date date;
    private Double transactionBalance;

    protected AccountTransaction() {}

    public AccountTransaction(AccountTransactionType type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = new Date();
        this.transactionBalance = 0.0;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public AccountTransactionType getType() {
        return type;
    }

    public void setType(AccountTransactionType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTransactionBalance() {
        return transactionBalance;
    }

    public void setTransactionBalance(Double transactionBalance) {
        this.transactionBalance = transactionBalance;
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionId=" + transactionId +
                ", type=" + type +
                ", amount=" + amount +
                ", date=" + date +
                ", transactionBalance=" + transactionBalance +
                '}';
    }
}
