package by.bsuir.oop.third.domain.furniture;

import by.bsuir.oop.third.domain.maker.Manufacturer;

public class Sofa extends Sit {
    private Manufacturer maker;

    public Sofa(int weight, int places) {
        super(weight, places);
    }

    public Sofa(int weight, int places, Manufacturer maker) {
        super(weight, places);
        this.maker = maker;
    }

    public Manufacturer getMaker() {
        return maker;
    }

    public void setMaker(Manufacturer maker) {
        this.maker = maker;
    }
}
