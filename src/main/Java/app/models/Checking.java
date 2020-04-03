package app.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("checking")
public class Checking extends Account {

    private final int MAX_NUM_OF_MONTHLY_WITHDRAWS = 3;
    private int numOfWithdraws;
    private String name;

    public Checking(){
        super();
        this.name = "checking";
        this.numOfWithdraws = 0;
    }

    public int getNumOfWithdraws() {
        return numOfWithdraws;
    }

    public void setNumOfWithdraws(int numOfWithdraws) {
        this.numOfWithdraws = numOfWithdraws;
    }
}
