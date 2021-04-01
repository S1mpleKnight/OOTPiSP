package by.bsuir.oop.third.domain.furniture;

import java.io.Serializable;

public abstract class Put extends Furniture implements Serializable {
    private Integer area;

    public Put(int weight, int area) {
        super(weight);
        this.area = area;
    }

    public Put() {
    }

    public Put(int weight) {
        super(weight);
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }
}
