package app.models;

import javax.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="accounts",
discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("account")
@Table(name="accounts")
public abstract class Account {

    @Id
    @GeneratedValue
    private Long accountId;
    private Double balance;
    private Boolean isActive;



    public Account(){
        this.balance = 0.0;
        this.isActive = true;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }



    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
