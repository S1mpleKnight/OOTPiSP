package by.bsuir.oop.third.furniture;

import java.io.Serializable;

public abstract class Furniture implements Serializable {
    private Integer weight;

    public Furniture(int weight) {
        this.weight = weight;
    }

    public Furniture() {
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
