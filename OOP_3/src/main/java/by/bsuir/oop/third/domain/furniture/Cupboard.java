package by.bsuir.oop.third.domain.furniture;

import by.bsuir.oop.third.domain.maker.Manufacturer;

public class Cupboard extends Cabinet {
    private int sections;

    public Cupboard(int width, int length, int sections) {
        super(width, length);
        this.sections = sections;
    }

    public Cupboard(Manufacturer maker, int width, int length, int sections) {
        super(maker, width, length);
        this.sections = sections;
    }

    public Cupboard(int sections) {
        this.sections = sections;
    }

    public Cupboard(Manufacturer maker, int sections) {
        super(maker);
        this.sections = sections;
    }

    public Cupboard() {
    }

    public Cupboard(Manufacturer maker) {
        super(maker);
    }

    public int getSections() {
        return sections;
    }

    public void setSections(int sections) {
        this.sections = sections;
    }
}
