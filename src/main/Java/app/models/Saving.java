package app.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("savings")
public class Saving extends app.models.Account {

    private double rate;
    private String name;

    public Saving(){
        super();
        this.name = "saving";
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
