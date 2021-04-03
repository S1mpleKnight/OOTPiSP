package by.bsuir.oop.third.domain.furniture;

import by.bsuir.oop.third.domain.maker.Manufacturer;

public class Wardrobe extends Cabinet {
    private int numberOfHooks;

    public Wardrobe(int width, int length, int numberOfHooks) {
        super(width, length);
        this.numberOfHooks = numberOfHooks;
    }

    public Wardrobe(Manufacturer maker, int width, int length, int numberOfHooks) {
        super(maker, width, length);
        this.numberOfHooks = numberOfHooks;
    }

    public Wardrobe(int numberOfHooks) {
        this.numberOfHooks = numberOfHooks;
    }

    public Wardrobe(Manufacturer maker, int numberOfHooks) {
        super(maker);
        this.numberOfHooks = numberOfHooks;
    }

    public Wardrobe(Manufacturer maker) {
        super(maker);
    }

    public Wardrobe() {
    }

    public int getNumberOfHooks() {
        return numberOfHooks;
    }

    public void setNumberOfHooks(int numberOfHooks) {
        this.numberOfHooks = numberOfHooks;
    }
}
