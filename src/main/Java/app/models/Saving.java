package app.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue("saving")
public class Saving extends Account implements Serializable {

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
