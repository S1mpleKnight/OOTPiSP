package by.bsuir.oop.fourth.domain.furniture;

import by.bsuir.oop.fourth.domain.maker.Manufacturer;

import java.io.Serializable;

public class Table extends Rack implements Serializable {
    private static final Long serialVersionUID = 2L;
    private int numberOfLegs;

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public Table(Manufacturer maker, Integer area, int numberOfLegs) {
        super(maker, area);
        this.numberOfLegs = numberOfLegs;
    }

    public Table() {
    }

    public Table(Integer area) {
        super(area);
    }

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Table" +
                ":maker=" + getMaker() +
                ":area=" + getArea() +
                ":legs=" + getNumberOfLegs();
    }
}
