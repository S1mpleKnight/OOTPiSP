package by.bsuir.oop.third.furniture;

import java.io.Serializable;

public abstract class Put extends Furniture implements Serializable {
    private int area;

    public Put(int weight, int area) {
        super(weight);
        this.area = area;
    }

    public Put() {
    }

    public Put(int weight) {
        super(weight);
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
}
