package by.bsuir.oop.fourth.domain.furniture;

import by.bsuir.oop.fourth.domain.maker.Manufacturer;

import java.io.Serializable;

public abstract class Furniture implements Serializable {
    private Manufacturer maker;

    public Furniture() {
    }

    public Furniture(Manufacturer maker) {
        this.maker = maker;
    }

    public Manufacturer getMaker() {
        return maker;
    }

    public void setMaker(Manufacturer maker) {
        this.maker = maker;
    }
}
