package com.karolk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@XmlRootElement
@Entity
public class FoodItem implements Serializable {

    //from the oracle documentation about the serialization.
    private static final long serialVersionUID = 42L;

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private float amount;

    public FoodItem(){}

    public FoodItem(String name, float amount){
        this.name = name;
        this.amount = amount;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
