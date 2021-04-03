package by.bsuir.oop.third.domain.furniture;

import by.bsuir.oop.third.domain.maker.Manufacturer;

import java.io.Serializable;

public abstract class Rack extends Furniture implements Serializable {
    private Integer area;

    public Rack() {
    }

    public Rack(Integer area) {
        this.area = area;
    }

    public Rack(Manufacturer maker, Integer area) {
        super(maker);
        this.area = area;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }
}
