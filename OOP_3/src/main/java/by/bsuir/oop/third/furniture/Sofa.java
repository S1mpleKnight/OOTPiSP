package by.bsuir.oop.third.furniture;

import by.bsuir.oop.third.maker.Manufacturer;

public class Sofa extends Sit{
    private Manufacturer maker;

    public Sofa(int weight, int places) {
        super(weight, places);
    }

    public Manufacturer getMaker() {
        return maker;
    }

    public void setMaker(Manufacturer maker) {
        this.maker = maker;
    }

    public Sofa(int weight, int places, Manufacturer maker) {
        super(weight, places);
        this.maker = maker;
    }
}
