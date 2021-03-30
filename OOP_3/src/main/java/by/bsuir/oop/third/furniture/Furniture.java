package by.bsuir.oop.third.furniture;

import java.io.Serializable;

public abstract class Furniture implements Serializable {
    private int weight;

    public Furniture(int weight) {
        this.weight = weight;
    }

    public Furniture() {
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
